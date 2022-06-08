package com.hexagonal.courseregistration.user;

public record RegisterRequest(
  String name,
  String idNumber,
  Authority authority
) {
}
