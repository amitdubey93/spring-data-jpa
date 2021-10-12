package io.h2o.springdatajpa.repository;

import io.h2o.springdatajpa.entities.Course;
import io.h2o.springdatajpa.entities.Student;
import io.h2o.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {


	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void printCourses() {
		List<Course> list = courseRepository.findAll();
		System.out.println("List of Courses: " + list);
	}


	@Test
	public void saveTeacherWithCourse() {

		Teacher teacher = Teacher.builder()
				.firstName("Biswajeet")
				.lastName("Dubey")
				.build();

		Course course = Course.builder()
				.courseTitle("Chemistry")
				.credit(4)
				.teacher(teacher)
				.build();
		courseRepository.save(course);
	}

	@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

		List<Course> courseList = courseRepository.findAll(secondPageWithTwoRecords).getContent();

		long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
		long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

		System.out.println("totalElements: " + totalElements);
		System.out.println("totalPages: " + totalPages);
		System.out.println("courseList: " + courseList);
	}

	@Test
	public void findAlLSorting() {
		Pageable sortByTitle = PageRequest.of(0, 5, Sort.by("courseTitle"));
		Pageable sortByCredit = PageRequest.of(0, 5, Sort.by("credit"));
		Pageable sortByCreditAndTitle = PageRequest.of(0, 5, Sort.by("credit").and(Sort.by("courseTitle")));


		List<Course> courseList = courseRepository.findAll(sortByTitle).getContent();
		List<Course> courseList1 = courseRepository.findAll(sortByCredit).getContent();
		List<Course> courseList2 = courseRepository.findAll(sortByCreditAndTitle).getContent();
		courseList.forEach(System.out::println);
		System.err.println();
		courseList1.forEach(System.out::println);
		System.err.println();
		courseList2.forEach(System.out::println);
	}


	@Test
	public void findByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);

		List<Course> courseList = courseRepository.findByCourseTitleContaining("a", firstPageTenRecords);
		courseList.forEach(System.err::println);
	}

	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("Ravi")
				.lastName("Singh")
				.build();


		Student student = Student.builder()
				.firstName("amit")
				.lastName("singh")
				.emailId("amit@outlook.com")
				.build();

		Course course = Course.builder()
				.courseTitle("AI")
				.credit(99)
				.teacher(teacher)
				.build();
		course.addStudent(student);

		courseRepository.save(course);
	}
}
