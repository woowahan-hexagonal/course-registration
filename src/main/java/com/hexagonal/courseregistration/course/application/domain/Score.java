package com.hexagonal.courseregistration.course.application.domain;

import com.hexagonal.courseregistration.course.application.error.CourseException;
import lombok.EqualsAndHashCode;

import static com.hexagonal.courseregistration.course.application.error.ErrorMessage.INVALID_SCORE;

@EqualsAndHashCode
public class Score {
  private final int score;

  public Score(int score) {
    if (score < 1 || 3 < score) {
      throw new CourseException(INVALID_SCORE);
    }
    this.score = score;
  }

  public int get() {
    return score;
  }
}
