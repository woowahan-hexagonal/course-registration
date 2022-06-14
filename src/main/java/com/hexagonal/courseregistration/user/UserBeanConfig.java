package com.hexagonal.courseregistration.user;

import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserAdapter;
import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
import com.hexagonal.courseregistration.user.application.RegisterUserUseCase;
import com.hexagonal.courseregistration.user.port.CheckExistUserPort;
import com.hexagonal.courseregistration.user.port.SaveUserPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserBeanConfig {
  @Bean
  CheckExistUserPort checkExistUserPort(JpaUserRepository jpaUserRepository) {
    return new JpaUserAdapter(jpaUserRepository);
  }

  @Bean
  SaveUserPort saveUserPort(JpaUserRepository jpaUserRepository) {
    return new JpaUserAdapter(jpaUserRepository);
  }

  @Bean
  RegisterUserUseCase registrant(
    CheckExistUserPort checkExistUserPort,
    SaveUserPort saveUserPort
  ) {
    return new RegisterUserUseCase(checkExistUserPort, saveUserPort);
  }
}
