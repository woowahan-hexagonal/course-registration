package com.hexagonal.courseregistration.user;

interface AllUser {
  boolean exist(String idNumber, Authority authority);

  void register(String name, String idNumber, Authority authority);
}
