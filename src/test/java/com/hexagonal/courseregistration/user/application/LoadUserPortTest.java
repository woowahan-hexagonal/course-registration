package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserAdapter;
import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
import com.hexagonal.courseregistration.user.adapter.persistence.UserConverter;
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
class LoadUserPortTest {
  @Autowired
  private JpaUserRepository jpaUserRepository;
  private LoadUserPort loadUserPort;
  private UserConverter converter = new UserConverter();

  @BeforeEach
  void init() {
    loadUserPort = new JpaUserAdapter(jpaUserRepository);
  }

  @Test
  void findById_not_exist() {
    var entity = jpaUserRepository.save(UserEntity.builder()
      .idNumber("220211230!")
      .name("George")
      .authority(PROFESSOR)
      .build());

    var actual = loadUserPort.findById(entity.id());

    assertThat(actual, is(converter.toUser(entity)));
  }
}