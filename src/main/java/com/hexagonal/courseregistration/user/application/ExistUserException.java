package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.common.ApiException;
import org.springframework.http.HttpStatus;

public class ExistUserException extends ApiException {
  public ExistUserException() {
    super(HttpStatus.BAD_REQUEST, "Already Exist User");
  }
}
