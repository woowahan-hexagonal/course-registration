package com.hexagonal.courseregistration.course.application;

import com.hexagonal.courseregistration.course.application.domain.CourseTime;
import com.hexagonal.courseregistration.course.application.domain.Duration;
import com.hexagonal.courseregistration.course.application.domain.Score;
import com.hexagonal.courseregistration.course.application.error.AuthorityException;
import com.hexagonal.courseregistration.course.application.error.CourseException;
import com.hexagonal.courseregistration.course.application.port.CheckExistCoursePort;
import com.hexagonal.courseregistration.course.application.port.RegisterRequest;
import com.hexagonal.courseregistration.course.application.port.SaveCoursePort;
import com.hexagonal.courseregistration.user.application.CheckAuthorityUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static com.hexagonal.courseregistration.course.application.domain.DayOfWeek.FRIDAY;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class RegisterCourseUseCaseTest {
  private RegisterCourseUseCase registerCourseUseCase;
  private CheckAuthorityUseCase checkAuthorityUseCase;
  private CheckExistCoursePort checkExistCoursePort;
  private SaveCoursePort saveCoursePort;

  @BeforeEach
  void init() {
    checkAuthorityUseCase = mock(CheckAuthorityUseCase.class);
    checkExistCoursePort = mock(CheckExistCoursePort.class);
    saveCoursePort = mock(SaveCoursePort.class);

    registerCourseUseCase = new RegisterCourseUseCase(
      checkAuthorityUseCase,
      checkExistCoursePort,
      saveCoursePort
    );
  }

  @Test
  void register() {
    var request = new RegisterRequest(
      1L,
      "캡스톤디자인",
      new Score(3),
      20,
      new CourseTime(FRIDAY, new Duration(1, 4)));
    given(checkAuthorityUseCase.isProfessor(anyLong())).willReturn(true);
    given(checkExistCoursePort.check(anyString())).willReturn(false);

    registerCourseUseCase.register(request);

    InOrder inOrder = Mockito.inOrder(checkAuthorityUseCase, checkExistCoursePort, saveCoursePort);
    inOrder.verify(checkAuthorityUseCase, times(1)).isProfessor(anyLong());
    inOrder.verify(checkExistCoursePort, times(1)).check(anyString());
    inOrder.verify(saveCoursePort, times(1)).save(any(RegisterRequest.class));
    verifyNoMoreInteractions(checkAuthorityUseCase);
    verifyNoMoreInteractions(checkExistCoursePort);
    verifyNoMoreInteractions(saveCoursePort);
  }

  @Test
  void register_not_professor() {
    var request = new RegisterRequest(
      1L,
      "캡스톤디자인",
      new Score(3),
      20,
      new CourseTime(FRIDAY, new Duration(1, 4)));
    given(checkAuthorityUseCase.isProfessor(anyLong())).willReturn(false);
    given(checkExistCoursePort.check(anyString())).willReturn(false);

    assertThrows(AuthorityException.class, () -> registerCourseUseCase.register(request));
  }

  @Test
  void register_exist_course() {
    var request = new RegisterRequest(
      1L,
      "캡스톤디자인",
      new Score(3),
      20,
      new CourseTime(FRIDAY, new Duration(1, 4)));
    given(checkAuthorityUseCase.isProfessor(anyLong())).willReturn(true);
    given(checkExistCoursePort.check(anyString())).willReturn(true);

    assertThrows(CourseException.class, () -> registerCourseUseCase.register(request));
  }
}