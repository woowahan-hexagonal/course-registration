package com.hexagonal.courseregistration.user.adapter.web;

import com.hexagonal.courseregistration.user.application.Authority;
import com.hexagonal.courseregistration.user.application.RegisterRequest;

record JsonRegisterRequest(
  String name,
  String idNumber,
  Authority authority
) {
  RegisterRequest toRegisterRequest() {
    return new RegisterRequest(name, idNumber, authority);
  }
}
