package com.hexagonal.courseregistration.course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static com.hexagonal.courseregistration.course.DayOfWeek.FRIDAY;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class RegisterCourseUseCaseTest {
  private RegisterCourseUseCase registerCourseUseCase;
  private CheckProfessorPort checkProfessorPort;
  private CheckExistCoursePort checkExistCoursePort;
  private SaveCoursePort saveCoursePort;

  @BeforeEach
  void init() {
    checkProfessorPort = mock(CheckProfessorPort.class);
    checkExistCoursePort = mock(CheckExistCoursePort.class);
    saveCoursePort = mock(SaveCoursePort.class);

    registerCourseUseCase = new RegisterCourseUseCase(
      checkProfessorPort,
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
    given(checkProfessorPort.check(anyLong())).willReturn(true);
    given(checkExistCoursePort.check(anyString())).willReturn(false);

    registerCourseUseCase.register(request);

    InOrder inOrder = Mockito.inOrder(checkProfessorPort, checkExistCoursePort, saveCoursePort);
    inOrder.verify(checkProfessorPort, times(1)).check(anyLong());
    inOrder.verify(checkExistCoursePort, times(1)).check(anyString());
    inOrder.verify(saveCoursePort, times(1)).save(any(RegisterRequest.class));
    verifyNoMoreInteractions(checkProfessorPort);
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
    given(checkProfessorPort.check(anyLong())).willReturn(false);
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
    given(checkProfessorPort.check(anyLong())).willReturn(true);
    given(checkExistCoursePort.check(anyString())).willReturn(true);

    assertThrows(CourseException.class, () -> registerCourseUseCase.register(request));
  }
}