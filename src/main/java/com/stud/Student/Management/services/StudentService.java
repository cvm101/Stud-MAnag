package com.stud.Student.Management.services;

import com.stud.Student.Management.dto.StudentDTO;

public interface StudentService {

    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(Long id);
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);
}
