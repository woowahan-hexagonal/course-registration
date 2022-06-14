package com.hexagonal.courseregistration.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {
  Optional<CourseEntity> findByCourseName(String courseName);
}
