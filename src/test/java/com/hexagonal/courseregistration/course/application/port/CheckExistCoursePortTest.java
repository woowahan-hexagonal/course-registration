package com.hexagonal.courseregistration.course.application.port;

import com.hexagonal.courseregistration.course.adapter.persistence.CourseEntity;
import com.hexagonal.courseregistration.course.adapter.persistence.JpaCourseAdapter;
import com.hexagonal.courseregistration.course.application.port.CheckExistCoursePort;
import com.hexagonal.courseregistration.course.application.domain.DayOfWeek;
import com.hexagonal.courseregistration.course.adapter.persistence.JpaCourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CheckExistCoursePortTest {
  @Autowired
  private JpaCourseRepository jpaCourseRepository;
  private CheckExistCoursePort checkExistCoursePort;

  @BeforeEach
  void init() {
    checkExistCoursePort = new JpaCourseAdapter(jpaCourseRepository);
  }

  @Test
  void check() {
    jpaCourseRepository.save(CourseEntity.builder()
      .courseName("내 몸 지키는 호신술")
      .dayOfWeek(DayOfWeek.MONDAY)
      .capacity(30)
      .score(2)
      .startTime(5)
      .endTime(7)
      .build());

    var actual = checkExistCoursePort.check("내 몸 지키는 호신술");

    assertThat(actual, is(true));
  }
}