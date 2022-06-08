package com.hexagonal.courseregistration.user;

interface AllUser {
  boolean exist(String idNumber, Authority authority);

  void register(User user);
}
