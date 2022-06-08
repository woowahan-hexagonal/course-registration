package com.hexagonal.courseregistration.user;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class Registrant {
  private final AllUser allUser;

  public void register(String name, String idNumber, Authority authority) {
    if (allUser.exist(idNumber, authority)) {
      throw new ExistUserException();
    }

    allUser.register(name, idNumber, authority);
  }
}
