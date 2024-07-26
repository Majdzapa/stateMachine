package com.state.machine.lifecycle.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class ErrorObject {

    private final String title;
    private final String description;
    private final LocalDateTime dateTime =  LocalDateTime.now();
}
