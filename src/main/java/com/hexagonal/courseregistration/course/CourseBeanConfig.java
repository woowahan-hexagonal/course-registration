package com.hexagonal.courseregistration.course;

import com.hexagonal.courseregistration.course.adapter.persistence.JpaCourseAdapter;
import com.hexagonal.courseregistration.course.adapter.persistence.JpaCourseRepository;
import com.hexagonal.courseregistration.course.application.*;
import com.hexagonal.courseregistration.course.application.port.CheckExistCoursePort;
import com.hexagonal.courseregistration.user.application.CheckAuthorityUseCase;
import com.hexagonal.courseregistration.course.application.port.SaveCoursePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseBeanConfig {
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
    CheckAuthorityUseCase checkAuthorityUseCase,
    CheckExistCoursePort checkExistCoursePort,
    SaveCoursePort saveCoursePort
  ) {
    return new RegisterCourseUseCase(checkAuthorityUseCase, checkExistCoursePort, saveCoursePort);
  }
}
