package com.hexagonal.courseregistration.user.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
  ALREADY_EXIST_USER("Already Exist User"),
  NOT_EXIST_USER("Not Exist User"),
  ;

  private final String detail;
}
