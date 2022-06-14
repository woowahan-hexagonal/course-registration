package com.hexagonal.courseregistration.course;

record Duration(Integer startTime, Integer endTime) {
  Duration {
    if ((startTime < 1 || 9 < startTime) ||
      (endTime < 1 || 9 < endTime) ||
      (endTime < startTime)) {
      throw new CourseException(Message.INVALID_DURATION);
    }
  }
}
