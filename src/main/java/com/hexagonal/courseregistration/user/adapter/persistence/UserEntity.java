package com.hexagonal.courseregistration.user.adapter.persistence;

import com.hexagonal.courseregistration.common.BaseEntity;
import com.hexagonal.courseregistration.user.application.Authority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
  private String idNumber;

  private String name;

  @Enumerated(value = EnumType.STRING)
  private Authority authority;

  @Builder
  public UserEntity(String name, String idNumber, Authority authority) {
    this.name = name;
    this.idNumber = idNumber;
    this.authority = authority;
  }
}
