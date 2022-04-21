package com.example.demo.global.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String message;

    public String convertJson(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}
