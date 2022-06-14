package com.hexagonal.courseregistration.course.application.port;

import com.hexagonal.courseregistration.course.application.domain.CourseTime;
import com.hexagonal.courseregistration.course.application.domain.Score;

public record RegisterRequest(
  Long userId,
  String courseName,
  Score score,
  Integer capacity,
  CourseTime courseTime
) {
}
