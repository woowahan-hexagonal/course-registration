package com.hexagonal.courseregistration.common.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class DomainException extends RuntimeException {
  private final String message;
}
