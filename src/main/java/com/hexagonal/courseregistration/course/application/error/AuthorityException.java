package com.hexagonal.courseregistration.course.application.error;

import com.hexagonal.courseregistration.common.application.ForbiddenException;

public class AuthorityException extends ForbiddenException {
  public AuthorityException(ErrorMessage errorMessage) {
    super(errorMessage.detail());
  }
}
