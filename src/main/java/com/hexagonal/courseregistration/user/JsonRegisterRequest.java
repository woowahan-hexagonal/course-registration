package com.hexagonal.courseregistration.user;

record JsonRegisterRequest(
  String name,
  String idNumber,
  Authority authority
) {
  RegisterRequest toRegisterRequest() {
    return new RegisterRequest(name, idNumber, authority);
  }
}
