package com.hexagonal.courseregistration.user.application;

import lombok.RequiredArgsConstructor;

import static com.hexagonal.courseregistration.user.application.ErrorMessage.ALREADY_EXIST_USER;

@RequiredArgsConstructor
public class RegisterUserUseCase {
  private final CheckExistUserPort checkExistUserPort;
  private final SaveUserPort saveUserPort;

  public void register(RegisterRequest request) {
    if (checkExistUserPort.check(request.idNumber(), request.authority())) {
      throw new UserException(ALREADY_EXIST_USER);
    }

    saveUserPort.save(new User(request.name(), request.idNumber(), request.authority()));
  }
}
