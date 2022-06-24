package com.hexagonal.courseregistration.user.adapter.persistence;

import com.hexagonal.courseregistration.user.application.User;
import org.junit.jupiter.api.Test;

import static com.hexagonal.courseregistration.user.application.Authority.STUDENT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class UserConverterTest {

  @Test
  void toUser() {
    var converter = new UserConverter();

    var actual = converter.toUser(new UserEntity(
      "17101223",
      "seungjaeOh",
      STUDENT
    ));

    assertThat(actual, is(new User(
      null,
      "seungjaeOh",
      "17101223",
      STUDENT
    )));
  }
}