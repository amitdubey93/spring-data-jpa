package io.h2o.springdatajpa.repository;

import io.h2o.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
//@DataJpaTest
class TeacherRepositoryTest {


	@Autowired
	private TeacherRepository teacherRepository;

//	@Test
//	public void saveTeacher() {
//
//		Course course1 = Course.builder()
//				.courseTitle("MAth")
//				.credit(7)
//				.build();
//		Course course2 = Course.builder()
//				.courseTitle("physics")
//				.credit(7)
//				.build();
//
//		Teacher teacher = Teacher.builder()
//				.firstName("Shakti")
//				.lastName("Singh")
//				.courses(Arrays.asList(course1,course2))
//				.build();
//
//		teacherRepository.save(teacher);
//
//	}

	@Test
	public void findAllById() {
		List<Long> list = new ArrayList<>();
		list.add(new Long(1));
		list.add(new Long(2));
		list.add(new Long(3));

		List<Teacher> teacherList = teacherRepository.findAllById(list);
		System.out.println(teacherList);
	}

}
