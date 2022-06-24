package com.hexagonal.courseregistration.user.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.hexagonal.courseregistration.user.application.Authority.PROFESSOR;
import static com.hexagonal.courseregistration.user.application.Authority.STUDENT;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class RegisterUserUseCaseTest {
  private IsExistUserPort isExistUserPort;
  private SaveUserPort saveUserPort;
  private RegisterUserUseCase registerUserUsecase;

  @BeforeEach
  void init() {
    isExistUserPort = mock(IsExistUserPort.class);
    saveUserPort = mock(SaveUserPort.class);
    registerUserUsecase = new RegisterUserUseCase(isExistUserPort, saveUserPort);
  }

  @Test
  void register_student() {
    var request = new RegisterRequest("seungjaeOh", "17101223", STUDENT);
    given(isExistUserPort.existByNumberAndAuthority("17101223", STUDENT)).willReturn(false);

    registerUserUsecase.register(request);

    var inOrder = inOrder(isExistUserPort, saveUserPort);
    inOrder.verify(isExistUserPort, times(1)).existByNumberAndAuthority(any(), any());
    inOrder.verify(saveUserPort, times(1)).save(any());
    verifyNoMoreInteractions(isExistUserPort);
    verifyNoMoreInteractions(saveUserPort);
  }

  @Test
  void register_professor() {
    var request = new RegisterRequest("chulsuKim", "221103", PROFESSOR);
    given(isExistUserPort.existByNumberAndAuthority("221103", PROFESSOR)).willReturn(false);

    registerUserUsecase.register(request);

    var inOrder = inOrder(isExistUserPort, saveUserPort);
    inOrder.verify(isExistUserPort, times(1)).existByNumberAndAuthority(any(), any());
    inOrder.verify(saveUserPort, times(1)).save(any());
    verifyNoMoreInteractions(isExistUserPort);
    verifyNoMoreInteractions(saveUserPort);
  }

  @Test
  void register_exist_user() {
    var request = new RegisterRequest(
      "seungjaeOh",
      "17101223",
      STUDENT);
    given(isExistUserPort.existByNumberAndAuthority("17101223", STUDENT)).willReturn(true);

    assertThrows(UserException.class, () -> registerUserUsecase.register(request));
  }
}