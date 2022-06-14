package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.common.application.ApiException;
import org.springframework.http.HttpStatus;

public class UserException extends ApiException {
  public UserException(Message message) {
    super(HttpStatus.BAD_REQUEST, message.detail());
  }
}
