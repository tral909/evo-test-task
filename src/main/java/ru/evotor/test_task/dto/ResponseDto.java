package ru.evotor.test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ResponseDto {

    int result;

    ExtrasDto extras;

    public ResponseDto(int result) {
        this.result = result;
        this.extras = null;
    }

}
