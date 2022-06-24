package com.hexagonal.courseregistration.user;

import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserAdapter;
import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
import com.hexagonal.courseregistration.user.application.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserBeanConfig {
  @Bean
  IsExistUserPort isExistUserPort(JpaUserRepository jpaUserRepository) {
    return new JpaUserAdapter(jpaUserRepository);
  }

  @Bean
  LoadUserPort loadUserPort(JpaUserRepository jpaUserRepository) {
    return new JpaUserAdapter(jpaUserRepository);
  }

  @Bean
  SaveUserPort saveUserPort(JpaUserRepository jpaUserRepository) {
    return new JpaUserAdapter(jpaUserRepository);
  }

  @Bean
  CheckAuthorityUseCase checkAuthorityUseCase(LoadUserPort loadUserPort) {
    return new CheckAuthorityUseCase(loadUserPort);
  }

  @Bean
  RegisterUserUseCase registerUserUseCase(
    IsExistUserPort loadUserPort,
    SaveUserPort saveUserPort
  ) {
    return new RegisterUserUseCase(loadUserPort, saveUserPort);
  }
}
