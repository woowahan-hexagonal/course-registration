package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.user.application.port.out.AllUser;
import com.hexagonal.courseregistration.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public
class Registrant {
  private final AllUser allUser;

  public void register(RegisterRequest request) {
    if (allUser.exist(request.idNumber(), request.authority())) {
      throw new ExistUserException();
    }

    allUser.register(new User(request.name(), request.idNumber(), request.authority()));
  }
}
