package ru.evotor.test_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.evotor.test_task.dto.RequestDto;
import ru.evotor.test_task.dto.ResponseDto;
import ru.evotor.test_task.dto.ResultCode;
import ru.evotor.test_task.service.CommonService;

@RestController
public class CommonController {

    private final CommonService commonService;

    @Autowired
    public CommonController(CommonService commonService) {
        this.commonService = commonService;
    }

    @PostMapping
    public ResponseDto request(@RequestBody RequestDto dto) {
        switch (dto.getType()) {
            case CREATE:
                return commonService.createUser(dto);
            case GET_BALANCE:
                return commonService.getBalance(dto);
            default:
                return new ResponseDto(ResultCode.INTERNAL_ERROR.getCode());
        }
    }

}
