package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.user.port.CheckExistUserPort;
import com.hexagonal.courseregistration.user.port.SaveUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.hexagonal.courseregistration.user.application.Authority.PROFESSOR;
import static com.hexagonal.courseregistration.user.application.Authority.STUDENT;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class RegisterUserUseCaseTest {
  private CheckExistUserPort checkExistUserPort;
  private SaveUserPort saveUserPort;
  private RegisterUserUseCase registerUserUsecase;

  @BeforeEach
  void init() {
    checkExistUserPort = mock(CheckExistUserPort.class);
    saveUserPort = mock(SaveUserPort.class);
    registerUserUsecase = new RegisterUserUseCase(checkExistUserPort, saveUserPort);
  }

  @Test
  void register_student() {
    var request = new RegisterRequest("seungjaeOh", "17101223", STUDENT);
    given(checkExistUserPort.check("17101223", STUDENT)).willReturn(false);

    registerUserUsecase.register(request);

    var inOrder = inOrder(checkExistUserPort, saveUserPort);
    inOrder.verify(checkExistUserPort, times(1)).check(any(), any());
    inOrder.verify(saveUserPort, times(1)).save(any());
    verifyNoMoreInteractions(checkExistUserPort);
    verifyNoMoreInteractions(saveUserPort);
  }

  @Test
  void register_professor() {
    var request = new RegisterRequest("chulsuKim", "221103", PROFESSOR);
    given(checkExistUserPort.check("221103", PROFESSOR)).willReturn(false);

    registerUserUsecase.register(request);

    var inOrder = inOrder(checkExistUserPort, saveUserPort);
    inOrder.verify(checkExistUserPort, times(1)).check(any(), any());
    inOrder.verify(saveUserPort, times(1)).save(any());
    verifyNoMoreInteractions(checkExistUserPort);
    verifyNoMoreInteractions(saveUserPort);
  }

  @Test
  void register_exist_user() {
    var request = new RegisterRequest("seungjaeOh", "17101223", STUDENT);
    given(checkExistUserPort.check("17101223", STUDENT)).willReturn(true);

    assertThrows(UserException.class, () -> registerUserUsecase.register(request));
  }
}