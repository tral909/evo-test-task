package ru.evotor.test_task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import ru.evotor.test_task.model.User;

public interface UserDao extends JpaRepository<User, Long> {

    @Nullable
    User findByLogin(String login);

}