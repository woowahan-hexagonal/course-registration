package com.hexagonal.courseregistration.course;

record RegisterRequest(
  Long userId,
  String courseName,
  Score score,
  Integer capacity,
  CourseTime courseTime
) {
}
