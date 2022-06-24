package com.hexagonal.courseregistration.user.application;

public interface IsExistUserPort {
  boolean existByNumberAndAuthority(String idNumber, Authority authority);
}
