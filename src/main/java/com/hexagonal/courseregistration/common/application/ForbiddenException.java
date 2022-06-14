package com.hexagonal.courseregistration.common.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class ForbiddenException extends RuntimeException {
  private final String message;
}
