package com.hexagonal.courseregistration.user.port;

import com.hexagonal.courseregistration.user.application.User;

public interface SaveUserPort {
  void save(User user);
}
