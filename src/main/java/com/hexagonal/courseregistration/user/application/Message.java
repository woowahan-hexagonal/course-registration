package com.hexagonal.courseregistration.user.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {
  ALREADY_EXIST_USER("Already Exist User"),
  ;

  private final String detail;
}
