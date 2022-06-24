package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserAdapter;
import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
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
class IsExistUserPortTest {
  @Autowired
  private JpaUserRepository jpaUserRepository;
  private IsExistUserPort isExistUserPort;

  @BeforeEach
  void init() {
    isExistUserPort = new JpaUserAdapter(jpaUserRepository);
  }

  @Test
  void existByIdNumberAndAuthority_false() {
    var actual = isExistUserPort.existByNumberAndAuthority("000000abc000!", STUDENT);

    assertThat(actual, is(false));
  }
}