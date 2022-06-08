package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.user.domain.Authority;

public record RegisterRequest(
  String name,
  String idNumber,
  Authority authority
) {
}
