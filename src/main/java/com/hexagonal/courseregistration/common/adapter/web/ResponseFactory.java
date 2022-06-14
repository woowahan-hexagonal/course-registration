package com.hexagonal.courseregistration.common.adapter.web;

import com.hexagonal.courseregistration.common.application.DomainException;
import com.hexagonal.courseregistration.common.application.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFactory {
  public static ResponseEntity<?> okWithData(String message, Object data) {
    return ResponseEntity.ok(new SuccessResponseWithData(message, data));
  }

  public static ResponseEntity<?> ok(String message) {
    return ResponseEntity.ok(new SuccessResponse(message));
  }

  public static ResponseEntity<?> badRequest(DomainException exception) {
    return ResponseEntity.badRequest().body(new ErrorResponse(exception.message()));
  }

  public static ResponseEntity<?> forbidden(ForbiddenException exception) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse(exception.message()));
  }

  public static ResponseEntity<?> fail(Exception exception) {
    return ResponseEntity.internalServerError().body(new ErrorResponse(exception.getMessage()));
  }
}
