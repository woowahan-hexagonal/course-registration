package com.hexagonal.courseregistration.course.application.domain;

import com.hexagonal.courseregistration.course.application.error.CourseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreTest {
  @Test
  void constructor_smaller_than_1() {
    assertThrows(CourseException.class, () -> new Score(0));
  }

  @Test
  void constructor_bigger_than_3() {
    assertThrows(CourseException.class, () -> new Score(4));
  }
}