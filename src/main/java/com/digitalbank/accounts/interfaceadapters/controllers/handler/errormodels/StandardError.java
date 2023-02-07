package com.digitalbank.accounts.interfaceadapters.controllers.handler.errormodels;

import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
public class StandardError {

    private final String path;
    private final Integer status;
    private final String message;
    private final ZonedDateTime timestamp;
    private final ErrorApiResponse error;
}