package com.hexagonal.courseregistration.user;

import org.junit.jupiter.api.Test;

import static com.hexagonal.courseregistration.user.Authority.PROFESSOR;
import static com.hexagonal.courseregistration.user.Authority.STUDENT;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class RegistrantTest {
  @Test
  void register_student() {
    var allUser = mock(AllUser.class);
    var registrant = new Registrant(allUser);
    var request = new RegisterRequest("seungjaeOh", "17101223", STUDENT);
    given(allUser.exist("17101223", STUDENT)).willReturn(false);

    registrant.register(request);

    var inOrder = inOrder(allUser);
    inOrder.verify(allUser, times(1)).exist("17101223", STUDENT);
    inOrder.verify(allUser, times(1)).register(
      new User(
        "seungjaeOh",
        "17101223",
        STUDENT
      )
    );
    verifyNoMoreInteractions(allUser);
  }

  @Test
  void register_professor() {
    var allUser = mock(AllUser.class);
    var registrant = new Registrant(allUser);
    var request = new RegisterRequest("chulsuKim", "221103", PROFESSOR);
    given(allUser.exist("221103", PROFESSOR)).willReturn(false);

    registrant.register(request);

    var inOrder = inOrder(allUser);
    inOrder.verify(allUser, times(1)).exist("221103", PROFESSOR);
    inOrder.verify(allUser, times(1)).register(
      new User(
        "chulsuKim",
        "221103",
        PROFESSOR
      )
    );
    verifyNoMoreInteractions(allUser);
  }

  @Test
  void register_exist_user() {
    var allUser = mock(AllUser.class);
    var registrant = new Registrant(allUser);
    var request = new RegisterRequest("seungjaeOh", "17101223", STUDENT);
    given(allUser.exist("17101223", STUDENT)).willReturn(true);

    assertThrows(ExistUserException.class, () -> registrant.register(request));
  }
}