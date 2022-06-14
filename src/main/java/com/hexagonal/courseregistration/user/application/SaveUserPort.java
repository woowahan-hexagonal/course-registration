package com.hexagonal.courseregistration.user.application;

import com.hexagonal.courseregistration.user.application.User;

public interface SaveUserPort {
  void save(User user);
}
