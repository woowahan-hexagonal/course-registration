package com.hexagonal.courseregistration.user.application;

public record RegisterRequest(
  String name,
  String idNumber,
  Authority authority
) {
}
