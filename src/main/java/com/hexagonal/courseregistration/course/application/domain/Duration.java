package com.hexagonal.courseregistration.course.application.domain;

import com.hexagonal.courseregistration.course.application.error.CourseException;
import com.hexagonal.courseregistration.course.application.error.ErrorMessage;

public record Duration(Integer startTime, Integer endTime) {
  public Duration {
    if ((startTime < 1 || 9 < startTime)
      || (endTime < 1 || 9 < endTime)
      || (endTime < startTime)) {
      throw new CourseException(ErrorMessage.INVALID_DURATION);
    }
  }
}
