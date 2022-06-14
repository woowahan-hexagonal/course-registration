package com.hexagonal.courseregistration.course;

import com.hexagonal.courseregistration.common.application.ForbiddenException;

public class AuthorityException extends ForbiddenException {
  public AuthorityException(Message message) {
    super(message.detail());
  }
}
