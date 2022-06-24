package com.hexagonal.courseregistration.course.application.error;

import com.hexagonal.courseregistration.common.application.DomainException;

public class UserException extends DomainException {
  public UserException(ErrorMessage errorMessage) {
    super(errorMessage.detail());
  }
}
