package com.hexagonal.courseregistration.course.application;

import com.hexagonal.courseregistration.course.application.error.AuthorityException;
import com.hexagonal.courseregistration.course.application.error.CourseException;
import com.hexagonal.courseregistration.course.application.error.Message;
import com.hexagonal.courseregistration.course.application.port.CheckExistCoursePort;
import com.hexagonal.courseregistration.course.application.port.CheckProfessorPort;
import com.hexagonal.courseregistration.course.application.port.RegisterRequest;
import com.hexagonal.courseregistration.course.application.port.SaveCoursePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterCourseUseCase {
  private final CheckProfessorPort checkProfessorPort;
  private final CheckExistCoursePort checkExistCoursePort;
  private final SaveCoursePort saveCoursePort;

  public void register(RegisterRequest request) {
    if (!checkProfessorPort.check(request.userId())) {
      throw new AuthorityException(Message.NOT_PROFESSOR);
    }

    if (checkExistCoursePort.check(request.courseName())) {
      throw new CourseException(Message.EXIST_COURSE);
    }

    saveCoursePort.save(request);
  }
}
