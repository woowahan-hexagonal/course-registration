package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.user.application.Authority;

public interface CheckExistUserPort {
  boolean check(String idNumber, Authority authority);
}
