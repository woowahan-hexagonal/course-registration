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
  public void register(String name, String idNumber, Authority authority) {
    jpaUserRepository.save(
      UserEntity.builder()
        .name(name)
        .idNumber(idNumber)
        .authority(authority)
        .build());
  }
}
