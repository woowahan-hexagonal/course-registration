package com.hexagonal.courseregistration.user.adapter.persistence;

import com.hexagonal.courseregistration.user.application.User;

public class UserConverter {
  public User toUser(UserEntity entity) {
    return new User(
      entity.id(),
      entity.name(),
      entity.idNumber(),
      entity.authority()
    );
  }
}
