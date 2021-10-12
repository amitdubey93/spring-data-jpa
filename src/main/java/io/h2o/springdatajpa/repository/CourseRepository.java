package io.h2o.springdatajpa.repository;

import io.h2o.springdatajpa.entities.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCourseTitleContaining(String title, Pageable pageable);

}
