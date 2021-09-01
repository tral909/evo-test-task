package ru.evotor.test_task.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.evotor.test_task.dao.UserDao;
import ru.evotor.test_task.dto.ExtrasDto;
import ru.evotor.test_task.dto.RequestDto;
import ru.evotor.test_task.dto.ResponseDto;
import ru.evotor.test_task.dto.ResultCode;
import ru.evotor.test_task.model.User;

@Slf4j
@Service
public class CommonService {

    private final UserDao userDao;

    @Autowired
    public CommonService(UserDao userDao) {
        this.userDao = userDao;
    }

    public ResponseDto createUser(RequestDto dto) {
        log.info("createUser method with dto {}", dto);
        try {
            User user = userDao.findByLogin(dto.getLogin());
            if (user == null) {
                User newUser = new User()
                        .setLogin(dto.getLogin())
                        .setPassword(dto.getPassword())
                        .setBalance(0.0);
                userDao.save(newUser);
                return new ResponseDto(ResultCode.OK.getCode());
            } else {
                return new ResponseDto(ResultCode.USER_EXISTS.getCode());
            }
        } catch (DataAccessException e) {
            log.error("{} code({}) occured", ResultCode.INTERNAL_ERROR.toString(), ResultCode.INTERNAL_ERROR.getCode(), e);
            return new ResponseDto(ResultCode.INTERNAL_ERROR.getCode());
        }
    }

    public ResponseDto getBalance(RequestDto dto) {
        log.info("getBalance method with dto {}", dto);
        try {
            User user = userDao.findByLogin(dto.getLogin());
            if (user == null) {
                return new ResponseDto(ResultCode.USER_NOT_EXISTS.getCode());
            } else if (user.getPassword().equals(dto.getPassword())) {
                return new ResponseDto(ResultCode.OK.getCode(), new ExtrasDto(user.getBalance()));
            } else {
                return new ResponseDto(ResultCode.PASSWORD_INCORRECT.getCode());
            }
        } catch (DataAccessException e) {
            log.error("{} code({}) occured", ResultCode.INTERNAL_ERROR.toString(), ResultCode.INTERNAL_ERROR.getCode(), e);
            return new ResponseDto(ResultCode.INTERNAL_ERROR.getCode());
        }
    }

}