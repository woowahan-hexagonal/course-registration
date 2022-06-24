package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.common.application.DomainException;

public class UserException extends DomainException {
  public UserException(ErrorMessage errorMessage) {
    super(errorMessage.detail());
  }
}
