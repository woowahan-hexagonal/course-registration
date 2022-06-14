package com.hexagonal.courseregistration.user.adapter.persistence;

import com.hexagonal.courseregistration.common.adapter.persistence.BaseEntity;
import com.hexagonal.courseregistration.user.application.Authority;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
@Table(name = "user")
public class UserEntity extends BaseEntity {
  private String idNumber;

  private String name;

  @Enumerated(value = EnumType.STRING)
  private Authority authority;
}
