package com.hexagonal.courseregistration.common.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public abstract class ApiException extends RuntimeException {
  private final HttpStatus status;
  private final String message;
}
