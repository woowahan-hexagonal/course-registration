package com.hexagonal.courseregistration.course.application.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
  NOT_PROFESSOR("Not Professor"),
  NOT_EXIST_USER("Not Exist User"),
  EXIST_COURSE("Exist Course Name"),
  INVALID_SCORE("Invalid Score"),
  INVALID_DURATION("Invalid Course Duration"),
  ;

  private final String detail;
}
