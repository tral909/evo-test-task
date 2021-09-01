package ru.evotor.test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    OK(0),
    USER_EXISTS(1),
    INTERNAL_ERROR(2),
    USER_NOT_EXISTS(3),
    PASSWORD_INCORRECT(4);

    private final int code;
}
