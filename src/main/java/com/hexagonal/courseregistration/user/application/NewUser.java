package com.hexagonal.courseregistration.user.application;

public record NewUser(
  String name,
  String idNumber,
  Authority authority
) {
}
