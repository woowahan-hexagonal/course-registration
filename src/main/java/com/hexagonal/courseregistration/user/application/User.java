package com.hexagonal.courseregistration.user.application;

public record User(
  String name,
  String idNumber,
  Authority authority
) {
}
