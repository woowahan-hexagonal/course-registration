package com.hexagonal.courseregistration.user.application;

public record User(
  Long id,
  String name,
  String idNumber,
  Authority authority
) {
}
