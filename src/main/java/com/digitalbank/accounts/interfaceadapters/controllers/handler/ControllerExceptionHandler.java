package com.digitalbank.accounts.interfaceadapters.controllers.handler;


import com.digitalbank.accounts.interfaceadapters.controllers.handler.errormodels.ErrorApiResponse;
import com.digitalbank.accounts.interfaceadapters.controllers.handler.errormodels.ErrorField;
import com.digitalbank.accounts.interfaceadapters.controllers.handler.errormodels.StandardError;
import com.digitalbank.accounts.usecases.exceptions.enums.ErrorType;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> handlerInternalServerError(final Exception exception) {
        log.error("Internal Server Error", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Exception> handlerNullPointerException(final NullPointerException exception) {
        log.error("Null pointer exception");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public ResponseEntity<StandardError> handlerServletRequestBindingException(final ServletRequestBindingException exception,
                                                                               final HttpServletRequest request) {
        log.error("ServletRequestBindingException: ", exception);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(this.standardErrorBuild(request, HttpStatus.BAD_REQUEST, ErrorType.DBA001, null));

    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<StandardError> handlerMissingRequestHeaderException(final MissingRequestHeaderException exception,
                                                                              final HttpServletRequest request) {

        log.error("MissingRequestHeaderException: ", exception);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(this.standardErrorBuild(request, HttpStatus.BAD_REQUEST, ErrorType.DBA001, null));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<StandardError> handlerMethodArgumentNotValidException(final BindException exception,
                                                                                final HttpServletRequest request) {
        log.error("BindException: ", exception);

        return this.getStandardBindResult(request, exception.getBindingResult());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handlerMethodArgumentNotValidException(final MethodArgumentNotValidException exception,
                                                                                final HttpServletRequest request) {
        log.error("MethodArgumentNotValidException: ", exception);

        return this.getStandardBindResult(request, exception.getBindingResult());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> handlerHttpMessageNotReadableException(final HttpMessageNotReadableException exception,
                                                                                final HttpServletRequest request) {
        log.error("HttpMessageNotReadableException: ", exception);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(this.standardErrorBuild(request, HttpStatus.BAD_REQUEST, ErrorType.DBA001, null));

    }

    private ResponseEntity<StandardError> getStandardBindResult(final HttpServletRequest request,
                                                                final BindingResult bindResult) {

        final var errors = bindResult.getFieldErrors().stream()
                .map(errorField -> new ErrorField(errorField.getField(), errorField.getDefaultMessage()))
                .distinct()
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(this.standardErrorBuild(request, HttpStatus.BAD_REQUEST, ErrorType.DBA001, errors));
    }

    private StandardError standardErrorBuild(final HttpServletRequest request, final HttpStatus status, final ErrorType errorType, final List<ErrorField> fields) {
        return StandardError.builder()
                        .path(request.getRequestURI())
                        .status(status.value())
                        .timestamp(ZonedDateTime.now())
                        .error(ErrorApiResponse.builder()
                                .code(errorType)
                                .message(errorType.getMessage(request.getLocale()))
                                .fields(fields)
                                .build())
                        .build();
    }
}