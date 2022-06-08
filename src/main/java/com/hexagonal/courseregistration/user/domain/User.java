package com.hexagonal.courseregistration.user.domain;

public record User(
  String name,
  String idNumber,
  Authority authority
) {
}
