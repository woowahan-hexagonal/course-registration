package com.hexagonal.courseregistration.user.application;

import lombok.RequiredArgsConstructor;

import static com.hexagonal.courseregistration.user.application.Authority.PROFESSOR;

@RequiredArgsConstructor
public class CheckAuthorityUseCase {
  private final LoadUserPort loadUserPort;

  public boolean isProfessor(Long id) {
    return loadUserPort.findById(id).authority() == PROFESSOR;
  }
}
