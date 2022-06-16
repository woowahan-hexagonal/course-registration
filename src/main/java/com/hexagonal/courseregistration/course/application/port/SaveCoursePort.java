package com.hexagonal.courseregistration.course.application.port;

public interface SaveCoursePort {
  void save(RegisterRequest request);
}
