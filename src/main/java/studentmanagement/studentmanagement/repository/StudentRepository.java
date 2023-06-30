package studentmanagement.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentmanagement.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
