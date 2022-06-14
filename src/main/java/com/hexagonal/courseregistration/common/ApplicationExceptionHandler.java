package com.hexagonal.courseregistration.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.hexagonal.courseregistration.common.JsonResponse.badRequest;
import static com.hexagonal.courseregistration.common.JsonResponse.fail;

@RestControllerAdvice
public class ApplicationExceptionHandler {

  @ExceptionHandler(value = ApiException.class)
  public ResponseEntity<?> handleBadRequest(ApiException exception) {
    return badRequest(exception);
  }

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<?> handleServerError(Exception exception) {
    return fail(exception);
  }
}
