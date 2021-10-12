package io.h2o.springdatajpa.repository;

import io.h2o.springdatajpa.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
