package com.hexagonal.courseregistration.user.port;

import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserAdapter;
import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
import com.hexagonal.courseregistration.user.application.CheckExistUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.hexagonal.courseregistration.user.application.Authority.STUDENT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CheckExistUserPortTest {
  @Autowired
  private JpaUserRepository jpaUserRepository;
  private CheckExistUserPort checkExistUserPort;

  @BeforeEach
  void init() {
    checkExistUserPort = new JpaUserAdapter(jpaUserRepository);
  }

  @Test
  void check() {
    var actual = checkExistUserPort.check("22101223231", STUDENT);

    assertThat(actual, is(false));
  }
}