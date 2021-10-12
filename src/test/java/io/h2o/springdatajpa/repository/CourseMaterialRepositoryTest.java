package io.h2o.springdatajpa.repository;

import io.h2o.springdatajpa.entities.Course;
import io.h2o.springdatajpa.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {


	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	@Test
	public void saveCoursematerial() {

		Course course = Course.builder()
				.courseTitle("Java")
				.credit(6)
				.build();

		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.yahoo.com")
				.course(course)
				.build();
		courseMaterialRepository.save(courseMaterial);
		//System.out.println("CourseMaterial: "+courseMaterial);

	}

	@Test
	public void getCourseMaterail() {
		List<CourseMaterial> list = courseMaterialRepository.findAll();
		System.out.println("list: " + list);
	}
}
