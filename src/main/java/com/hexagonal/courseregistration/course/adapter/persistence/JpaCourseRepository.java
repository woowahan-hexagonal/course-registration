package com.hexagonal.courseregistration.course.adapter.persistence;

import com.hexagonal.courseregistration.course.adapter.persistence.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {
  Optional<CourseEntity> findByCourseName(String courseName);
}
