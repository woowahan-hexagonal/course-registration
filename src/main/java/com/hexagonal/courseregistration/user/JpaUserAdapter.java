package com.hexagonal.courseregistration.user;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JpaUserAdapter implements AllUser {
  private final JpaUserRepository jpaUserRepository;

  @Override
  public boolean exist(String idNumber, Authority authority) {
    return jpaUserRepository.findByIdNumberAndAuthority(idNumber, authority).isPresent();
  }

  @Override
  @Transactional
  public void register(User user) {
    jpaUserRepository.save(
      UserEntity.builder()
        .name(user.name())
        .idNumber(user.idNumber())
        .authority(user.authority())
        .build());
  }
}
