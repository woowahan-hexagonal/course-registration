package com.hexagonal.courseregistration.user.adapter.persistence;

import com.hexagonal.courseregistration.user.application.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByIdNumberAndAuthority(String idNumber, Authority authority);
}
