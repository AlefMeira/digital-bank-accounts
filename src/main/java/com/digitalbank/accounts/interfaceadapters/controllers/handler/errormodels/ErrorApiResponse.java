package com.digitalbank.accounts.interfaceadapters.controllers.handler.errormodels;

import com.digitalbank.accounts.usecases.exceptions.enums.ErrorType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorApiResponse {

    private ErrorType code;
    private String message;
    private List<ErrorField> fields;
}