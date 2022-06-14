package com.hexagonal.courseregistration.course;

import com.hexagonal.courseregistration.common.adapter.persistence.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
@Table(name = "course")
public class CourseEntity extends BaseEntity {
  private String courseName;
  private DayOfWeek dayOfWeek;
  private int startTime;
  private int endTime;
  private int capacity;
  private int score;
}
