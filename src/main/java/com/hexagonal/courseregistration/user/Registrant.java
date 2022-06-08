package com.hexagonal.courseregistration.user;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class Registrant {
  private final AllUser allUser;

  public void register(RegisterRequest request) {
    if (allUser.exist(request.idNumber(), request.authority())) {
      throw new ExistUserException();
    }

    allUser.register(new User(request.name(), request.idNumber(), request.authority()));
  }
}
