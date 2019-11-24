package com.heriparid.lab.querydsl;

import com.heriparid.lab.querydsl.persistence.dao.CourseRepository;
import com.heriparid.lab.querydsl.persistence.dao.LecturerRepository;
import com.heriparid.lab.querydsl.persistence.model.Course;
import com.heriparid.lab.querydsl.persistence.model.Lecturer;
import com.heriparid.lab.querydsl.persistence.model.QCourse;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuerydslApplicationTests {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private LecturerRepository lecturerRepository;

	@Autowired
	private JPAQueryFactory queryFactory;


	/**
	 * Initialization data
	 */
	@BeforeEach
	public void initData(){
		// Clear data table
		courseRepository.deleteAll();
		lecturerRepository.deleteAll();

		// Initialize instructor
		Lecturer tom=new Lecturer();
		tom.setName("Tom");
		tom.setSex(true);
		lecturerRepository.save(tom);

		Lecturer marry=new Lecturer();
		marry.setName("Marry");
		marry.setSex(false);
		lecturerRepository.save(marry);

		// Initialize course
		Course chinese=new Course();
		chinese.setName("Chinese");
		chinese.setLecturerId(tom.getId());
		courseRepository.save(chinese);

		Course physics=new Course();
		physics.setName("Physics");
		physics.setLecturerId(tom.getId());
		courseRepository.save(physics);

		Course english=new Course();
		english.setName("English");
		english.setLecturerId(marry.getId());
		courseRepository.save(english);
	}

	/**
	 * Fuzzy query course according to course name
	 */
	@Test
	public void testSelectCourseByNameLike() {
		// Assembly query criteria
		QCourse qCourse = QCourse.course;
		// %Self assembly
		BooleanExpression expression = qCourse.name.like("P%");
		System.out.println(courseRepository.findAll(expression));
	}
}
