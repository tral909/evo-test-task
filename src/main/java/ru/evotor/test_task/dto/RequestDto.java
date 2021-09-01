package ru.evotor.test_task.dto;

import lombok.Value;

@Value
public class RequestDto {

    RequestType type;

    String login;

    String password;

}
