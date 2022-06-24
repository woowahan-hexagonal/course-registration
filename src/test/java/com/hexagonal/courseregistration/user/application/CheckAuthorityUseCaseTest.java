package com.hexagonal.courseregistration.user.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.hexagonal.courseregistration.user.application.Authority.PROFESSOR;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class CheckAuthorityUseCaseTest {
  private LoadUserPort loadUserPort;
  private CheckAuthorityUseCase checkAuthorityUseCase;

  @BeforeEach
  void init() {
    loadUserPort = mock(LoadUserPort.class);
    checkAuthorityUseCase = new CheckAuthorityUseCase(loadUserPort);
  }

  @Test
  void isProfessor() {
    given(loadUserPort.findById(any())).willReturn(new User(
      1L,
      "chulsuKim",
      "22011245",
      PROFESSOR
    ));

    var actual = checkAuthorityUseCase.isProfessor(1L);

    assertThat(actual, is(true));
    verify(loadUserPort, times(1)).findById(1L);
    verifyNoMoreInteractions(loadUserPort);
  }
}