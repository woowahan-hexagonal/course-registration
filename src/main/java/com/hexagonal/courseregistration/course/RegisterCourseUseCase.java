package com.hexagonal.courseregistration.course;

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
