package com.stud.Student.Management.repository;

import com.stud.Student.Management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
