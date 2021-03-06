package com.hexagonal.courseregistration.course.application.port;

import com.hexagonal.courseregistration.course.adapter.persistence.JpaCourseAdapter;
import com.hexagonal.courseregistration.course.adapter.persistence.JpaCourseRepository;
import com.hexagonal.courseregistration.course.application.domain.CourseTime;
import com.hexagonal.courseregistration.course.application.domain.Duration;
import com.hexagonal.courseregistration.course.application.domain.Score;
import com.hexagonal.courseregistration.course.application.port.RegisterRequest;
import com.hexagonal.courseregistration.course.application.port.SaveCoursePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.hexagonal.courseregistration.course.application.domain.DayOfWeek.FRIDAY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SaveCoursePortTest {
  @Autowired
  private JpaCourseRepository jpaCourseRepository;
  private SaveCoursePort saveCoursePort;

  @BeforeEach
  void init() {
    saveCoursePort = new JpaCourseAdapter(jpaCourseRepository);
  }

  @Test
  void save() {
    var count = jpaCourseRepository.count();

    saveCoursePort.save(
      new RegisterRequest(
        1L,
        "캡스톤디자인",
        new Score(3),
        20,
        new CourseTime(FRIDAY, new Duration(1, 4))));

    assertThat(jpaCourseRepository.count(), is(count + 1));
  }
}