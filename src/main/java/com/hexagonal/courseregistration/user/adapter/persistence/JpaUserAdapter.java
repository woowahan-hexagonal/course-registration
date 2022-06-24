package com.hexagonal.courseregistration.user.adapter.persistence;

import com.hexagonal.courseregistration.user.application.*;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import static com.hexagonal.courseregistration.user.application.ErrorMessage.NOT_EXIST_USER;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JpaUserAdapter implements LoadUserPort, SaveUserPort, IsExistUserPort {
  private final JpaUserRepository jpaUserRepository;
  private final UserConverter converter = new UserConverter();

  @Transactional
  @Override
  public void save(NewUser newUser) {
    jpaUserRepository.save(
      UserEntity.builder()
        .name(newUser.name())
        .idNumber(newUser.idNumber())
        .authority(newUser.authority())
        .build());
  }

  @Override
  public User findById(Long id) {
    var entity = jpaUserRepository.findById(id);

    if (entity.isEmpty()) {
      throw new UserException(NOT_EXIST_USER);
    }

    return converter.toUser(entity.get());
  }

  @Override
  public boolean existByNumberAndAuthority(String idNumber, Authority authority) {
    return jpaUserRepository.findByIdNumberAndAuthority(idNumber, authority).isPresent();
  }
}
