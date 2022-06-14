package com.hexagonal.courseregistration.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DurationTest {
  @Test
  void constructor_start_bigger_than_end() {
    assertThrows(CourseException.class, () -> new Duration(6, 5));
  }

  @Test
  void constructor_smaller_than_1() {
    assertThrows(CourseException.class, () -> new Duration(0, 5));
  }

  @Test
  void constructor_bigger_than_9() {
    assertThrows(CourseException.class, () -> new Duration(1, 10));
  }
}