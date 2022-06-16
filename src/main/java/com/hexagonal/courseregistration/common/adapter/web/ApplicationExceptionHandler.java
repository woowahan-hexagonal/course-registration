package com.hexagonal.courseregistration.common.adapter.web;

import com.hexagonal.courseregistration.common.application.DomainException;
import com.hexagonal.courseregistration.common.application.ForbiddenException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.hexagonal.courseregistration.common.adapter.web.ResponseFactory.*;

@RestControllerAdvice
public class ApplicationExceptionHandler {

  @ExceptionHandler(value = DomainException.class)
  public ResponseEntity<?> handleBadRequest(DomainException exception) {
    return badRequest(exception);
  }

  @ExceptionHandler(value = ForbiddenException.class)
  public ResponseEntity<?> handleForbidden(ForbiddenException exception) {
    return forbidden(exception);
  }

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<?> handleServerError(Exception exception) {
    return fail(exception);
  }
}
