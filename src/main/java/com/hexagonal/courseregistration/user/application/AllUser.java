package com.hexagonal.courseregistration.user.application;

public interface AllUser {
  boolean exist(String idNumber, Authority authority);

  void register(User user);
}
