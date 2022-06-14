package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserAdapter;
import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.hexagonal.courseregistration.user.application.Authority.PROFESSOR;
import static com.hexagonal.courseregistration.user.application.Authority.STUDENT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AllUserTest {

  @Autowired
  private JpaUserRepository jpaUserRepository;
  private AllUser allUser;

  @BeforeEach
  void init() {
    allUser = new JpaUserAdapter(jpaUserRepository);
  }

  @Test
  void exist() {
    var actual = allUser.exist("22101223", STUDENT);

    assertThat(actual, is(false));
  }

  @Test
  void register_student() {
    allUser.register(new User(
      "samKim",
      "22101223",
      STUDENT
    ));
    var actual = allUser.exist("22101223", STUDENT);

    assertThat(actual, is(true));
  }

  @Test
  void register_professor() {
    allUser.register(new User(
      "samKim",
      "22111022",
      PROFESSOR
    ));
    var actual = allUser.exist("22111022", PROFESSOR);

    assertThat(actual, is(true));
  }
}
