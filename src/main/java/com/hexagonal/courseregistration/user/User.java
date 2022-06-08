package com.hexagonal.courseregistration.user;

public record User(
  String name,
  String idNumber,
  Authority authority
) {
}
