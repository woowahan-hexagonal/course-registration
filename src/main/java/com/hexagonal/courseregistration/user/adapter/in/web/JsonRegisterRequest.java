package com.hexagonal.courseregistration.user.adapter.in.web;

import com.hexagonal.courseregistration.user.domain.Authority;
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
