package com.hexagonal.courseregistration.course.application.error;

import com.hexagonal.courseregistration.common.application.DomainException;

public class CourseException extends DomainException {
  public CourseException(ErrorMessage errorMessage) {
    super(errorMessage.detail());
  }
}
