package com.hexagonal.courseregistration.user;

record JsonRegisterRequest(
  String name,
  String idNumber,
  Authority authority
) {
}
