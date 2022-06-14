package com.hexagonal.courseregistration.course;

import com.hexagonal.courseregistration.common.application.DomainException;

public class UserException extends DomainException {
  public UserException(Message message) {
    super(message.detail());
  }
}
