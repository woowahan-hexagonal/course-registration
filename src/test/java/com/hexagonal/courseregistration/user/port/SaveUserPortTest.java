package com.hexagonal.courseregistration.user.port;

import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserAdapter;
import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
import com.hexagonal.courseregistration.user.application.SaveUserPort;
import com.hexagonal.courseregistration.user.application.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.hexagonal.courseregistration.user.application.Authority.PROFESSOR;
import static com.hexagonal.courseregistration.user.application.Authority.STUDENT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SaveUserPortTest {
  @Autowired
  private JpaUserRepository jpaUserRepository;
  private SaveUserPort saveUserPort;

  @BeforeEach
  void init() {
    saveUserPort = new JpaUserAdapter(jpaUserRepository);
  }

  @Test
  void save_student() {
    var count = jpaUserRepository.count();

    saveUserPort.save(new User(
      "samKim",
      "22101223231",
      STUDENT
    ));

    assertThat(jpaUserRepository.count(), is(count + 1));
  }

  @Test
  void save_professor() {
    var count = jpaUserRepository.count();

    saveUserPort.save(new User(
      "samKim",
      "22101223231",
      PROFESSOR
    ));

    assertThat(jpaUserRepository.count(), is(count + 1));
  }
}