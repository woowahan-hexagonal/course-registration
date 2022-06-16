package com.hexagonal.courseregistration.user.adapter.persistence;

import com.hexagonal.courseregistration.user.application.Authority;
import com.hexagonal.courseregistration.user.application.User;
import com.hexagonal.courseregistration.user.application.CheckExistUserPort;
import com.hexagonal.courseregistration.user.application.SaveUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JpaUserAdapter implements CheckExistUserPort, SaveUserPort {
  private final JpaUserRepository jpaUserRepository;

  @Override
  @Transactional
  public void save(User user) {
    jpaUserRepository.save(
      UserEntity.builder()
        .name(user.name())
        .idNumber(user.idNumber())
        .authority(user.authority())
        .build());
  }

  @Override
  public boolean check(String idNumber, Authority authority) {
    return jpaUserRepository.findByIdNumberAndAuthority(idNumber, authority).isPresent();
  }
}
