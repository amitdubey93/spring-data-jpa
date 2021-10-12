package io.h2o.springdatajpa.repository;

import io.h2o.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstName(String firstName);

	List<Student> findByFirstNameContaining(String firstName);

	List<Student> findByLastNameNotNull();

	List<Student> findByGuardianName(String name);

	List<Student> findByFirstNameAndLastName(String firstName, String lastName);

	// JPQL
	@Query("select s from Student s where s.emailId=?1")
	Student getStudentByEmailAddress(String email);

	@Query("select s.firstName from Student s where s.emailId=?1")
	String getStudentFirstNameByEmailAddress(String email);

	// Native Query
	@Query(value = "select * from tbl_student s where s.email_address=?1", nativeQuery = true)
	Student getStudentByEmailAddressNative(String email);

	// Native Named Query
	@Query(value = "select * from tbl_student s where s.email_address= :emailId", nativeQuery = true)
	Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

	//update query
	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name=?1 where email_address=?2", nativeQuery = true)
	int updateStudentFirstNameByEmailId(String firstName, String emailId);


}
