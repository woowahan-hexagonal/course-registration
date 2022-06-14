package com.hexagonal.courseregistration.course;

import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseBeanConfig {
  @Bean
  CheckProfessorPort checkProfessorPort(JpaUserRepository jpaUserRepository) {
    return new JpaUserAdapter(jpaUserRepository);
  }

  @Bean
  CheckExistCoursePort checkExistCoursePort(JpaCourseRepository jpaCourseRepository) {
    return new JpaCourseAdapter(jpaCourseRepository);
  }

  @Bean
  SaveCoursePort saveCoursePort(JpaCourseRepository jpaCourseRepository) {
    return new JpaCourseAdapter(jpaCourseRepository);
  }

  @Bean
  RegisterCourseUseCase registerCourseUseCase(
    CheckProfessorPort checkProfessorPort,
    CheckExistCoursePort checkExistCoursePort,
    SaveCoursePort saveCoursePort
  ) {
    return new RegisterCourseUseCase(checkProfessorPort, checkExistCoursePort, saveCoursePort);
  }
}
