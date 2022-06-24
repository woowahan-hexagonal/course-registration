package com.hexagonal.courseregistration.course.adapter.persistence;

import com.hexagonal.courseregistration.course.application.port.CheckProfessorPort;
import com.hexagonal.courseregistration.course.application.error.UserException;
import com.hexagonal.courseregistration.user.adapter.persistence.JpaUserRepository;
import com.hexagonal.courseregistration.user.application.Authority;
import lombok.RequiredArgsConstructor;

import static com.hexagonal.courseregistration.course.application.error.ErrorMessage.NOT_EXIST_USER;

@RequiredArgsConstructor
public class JpaUserAdapter implements CheckProfessorPort {
  private final JpaUserRepository jpaUserRepository;

  @Override
  public boolean check(Long id) {
    return jpaUserRepository.findById(id)
      .orElseThrow(() -> new UserException(NOT_EXIST_USER)).authority() == Authority.PROFESSOR;
  }
}
