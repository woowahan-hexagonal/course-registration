package com.hexagonal.courseregistration.course;

import com.hexagonal.courseregistration.common.application.DomainException;

public class CourseException extends DomainException {
  public CourseException(Message message) {
    super(message.detail());
  }
}
