package com.hexagonal.courseregistration.user.application;

public interface CheckExistUserPort {
  boolean check(String idNumber, Authority authority);
}
