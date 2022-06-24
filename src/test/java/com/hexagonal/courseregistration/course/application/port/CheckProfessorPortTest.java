package com.hexagonal.courseregistration.course.application.port;

import com.hexagonal.courseregistration.course.adapter.persistence.JpaUserAdapter;
import com.hexagonal.courseregistration.course.application.port.CheckProfessorPort;
import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
import com.hexagonal.courseregistration.user.adapter.persistence.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.hexagonal.courseregistration.user.application.Authority.PROFESSOR;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CheckProfessorPortTest {
  @Autowired
  private JpaUserRepository jpaUserRepository;
  private CheckProfessorPort checkProfessorPort;

  @BeforeEach
  void init() {
    checkProfessorPort = new JpaUserAdapter(jpaUserRepository);
  }

  @Test
  void check() {
    var user = jpaUserRepository.save(UserEntity.builder()
      .idNumber("203123412")
      .name("홍길동")
      .authority(PROFESSOR)
      .build());

    var actual = checkProfessorPort.check(user.id());

    assertThat(actual, is(true));
  }
}