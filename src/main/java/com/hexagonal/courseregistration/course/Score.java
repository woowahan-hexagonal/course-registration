package com.hexagonal.courseregistration.course;

import lombok.EqualsAndHashCode;

import static com.hexagonal.courseregistration.course.Message.INVALID_SCORE;

@EqualsAndHashCode
class Score {
  private final int score;

  Score(int score) {
    if (score < 1 || 3 < score) {
      throw new CourseException(INVALID_SCORE);
    }
    this.score = score;
  }

  public int get() {
    return score;
  }
}
