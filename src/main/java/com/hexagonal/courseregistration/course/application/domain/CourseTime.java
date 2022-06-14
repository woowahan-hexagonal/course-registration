package com.hexagonal.courseregistration.course.application.domain;

public record CourseTime(
  DayOfWeek dayOfWeek,
  Duration duration
) {
}
