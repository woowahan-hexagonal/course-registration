package com.hexagonal.courseregistration.user.application.port.out;

import com.hexagonal.courseregistration.user.domain.Authority;
import com.hexagonal.courseregistration.user.domain.User;

public interface AllUser {
  boolean exist(String idNumber, Authority authority);

  void register(User user);
}
