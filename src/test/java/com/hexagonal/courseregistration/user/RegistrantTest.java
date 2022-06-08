package com.hexagonal.courseregistration.user;

import org.junit.jupiter.api.Test;

import static com.hexagonal.courseregistration.user.Authority.STUDENT;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class RegistrantTest {
  @Test
  void register_student() {
    var allUser = mock(AllUser.class);
    var registrant = new Registrant(allUser);
    given(allUser.exist("17101223", STUDENT)).willReturn(false);

    registrant.register("SeungjaeOh", "17101223", STUDENT);

    var inOrder = inOrder(allUser);
    inOrder.verify(allUser, times(1)).exist("17101223", STUDENT);
    inOrder.verify(allUser, times(1)).register("SeungjaeOh", "17101223", STUDENT);
    verifyNoMoreInteractions(allUser);
  }
}