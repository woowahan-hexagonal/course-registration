package com.hexagonal.courseregistration.user;

import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserAdapter;
import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
import com.hexagonal.courseregistration.user.application.AllUser;
import com.hexagonal.courseregistration.user.application.Registrant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration("UserBeanConfig")
class BeanConfig {
  @Bean
  AllUser allUser(JpaUserRepository jpaUserRepository) {
    return new JpaUserAdapter(jpaUserRepository);
  }

  @Bean
  Registrant registrant(AllUser allUser) {
    return new Registrant(allUser);
  }
}