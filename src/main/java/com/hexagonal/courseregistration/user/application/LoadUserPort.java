package com.hexagonal.courseregistration.user.application;

public interface LoadUserPort {
  User findById(Long id);
}
