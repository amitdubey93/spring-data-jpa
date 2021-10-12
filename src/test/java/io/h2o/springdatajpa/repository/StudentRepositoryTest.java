package io.h2o.springdatajpa.repository;

import io.h2o.springdatajpa.entities.Guardian;
import io.h2o.springdatajpa.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

//	@Test
//	public void saveStudent() {
//		Student student = Student.builder()
//				.firstName("Amit")
//				.lastName("Dubey")
//				.emailId("amit@gmail.com")
//				.guardianName("Subhas")
//				.guardianEmail("subhas@gmail.com")
//				.guardianMobile("102369852")
//				.build();
//
//		studentRepository.save(student);
//	}

	@Test
	public void prinlAllStudent() {
		List<Student> list = studentRepository.findAll();
		System.err.println(list);
	}

	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder()
				.name("Subhas")
				.email("subhas1@gmail.com")
				.mobile("123647885")
				.build();


		Student student = Student.builder()
				.firstName("Amit")
				.lastName("Dubey")
				.emailId("amit1@gmail.com")
				.guardian(guardian)
				.build();

		studentRepository.save(student);
	}


	@Test
	public void findByFirstName() {
		List<Student> student = studentRepository.findByFirstName("amit");
		System.out.println("student: " + student);
	}

	@Test
	public void findByFirstNameContaining() {
		List<Student> student = studentRepository.findByFirstNameContaining("it");
		System.out.println("student: " + student);
	}


	@Test
	public void findByLastNameNotNull() {
		List<Student> student = studentRepository.findByLastNameNotNull();
		System.out.println("student: " + student);
	}

	@Test
	public void findByGuardianName() {
		List<Student> student = studentRepository.findByGuardianName("subhas");
		System.out.println("student: " + student);
	}

	@Test
	public void findByFirstNameAndLastName() {
		List<Student> student = studentRepository.findByFirstNameAndLastName("amit", "dubey");
		System.out.println("student: " + student);
	}

	@Test
	public void getStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("amit@gmail.com");
		System.out.println("student: " + student);
	}

	@Test
	public void getStudentFirstNameByEmailAddress() {
		String student = studentRepository.getStudentFirstNameByEmailAddress("amit@gmail.com");
		System.out.println("student: " + student);
	}


	@Test
	public void getStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("amit1@gmail.com");
		System.out.println("student: " + student);
	}

	@Test
	public void getStudentByEmailAddressNativeNamedParam() {
		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("amit1@gmail.com");
		System.out.println("student: " + student);
	}

	@Test
	public void updateStudentFirstNameByEmailId() {
		int value = studentRepository.updateStudentFirstNameByEmailId("manjeet", "amit1a@gmail.com");
		System.out.println("value: " + value);
	}
}
