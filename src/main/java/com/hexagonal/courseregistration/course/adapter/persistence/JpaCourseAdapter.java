package com.hexagonal.courseregistration.course.adapter.persistence;

import com.hexagonal.courseregistration.course.application.port.CheckExistCoursePort;
import com.hexagonal.courseregistration.course.application.port.RegisterRequest;
import com.hexagonal.courseregistration.course.application.port.SaveCoursePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaCourseAdapter implements CheckExistCoursePort, SaveCoursePort {
  private final JpaCourseRepository jpaCourseRepository;

  @Override
  public boolean check(String courseName) {
    return jpaCourseRepository.findByCourseName(courseName).isPresent();
  }

  @Override
  public void save(RegisterRequest request) {
    jpaCourseRepository.save(CourseEntity.builder()
      .courseName(request.courseName())
      .dayOfWeek(request.courseTime().dayOfWeek())
      .capacity(request.capacity())
      .score(request.score().get())
      .startTime(request.courseTime().duration().startTime())
      .endTime(request.courseTime().duration().endTime())
      .build());
  }
}
