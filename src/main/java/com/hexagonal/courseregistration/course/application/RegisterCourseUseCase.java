package com.hexagonal.courseregistration.course.application;

import com.hexagonal.courseregistration.course.application.error.AuthorityException;
import com.hexagonal.courseregistration.course.application.error.CourseException;
import com.hexagonal.courseregistration.course.application.error.ErrorMessage;
import com.hexagonal.courseregistration.course.application.port.CheckExistCoursePort;
import com.hexagonal.courseregistration.course.application.port.RegisterRequest;
import com.hexagonal.courseregistration.course.application.port.SaveCoursePort;
import com.hexagonal.courseregistration.user.application.CheckAuthorityUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterCourseUseCase {
  private final CheckAuthorityUseCase checkAuthorityUseCase;
  private final CheckExistCoursePort checkExistCoursePort;
  private final SaveCoursePort saveCoursePort;

  public void register(RegisterRequest request) {
    if (!checkAuthorityUseCase.isProfessor(request.userId())) {
      throw new AuthorityException(ErrorMessage.NOT_PROFESSOR);
    }

    if (checkExistCoursePort.check(request.courseName())) {
      throw new CourseException(ErrorMessage.EXIST_COURSE);
    }

    saveCoursePort.save(request);
  }
}
