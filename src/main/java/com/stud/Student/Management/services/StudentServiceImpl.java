package com.stud.Student.Management.services;

import com.stud.Student.Management.dto.StudentDTO;
import com.stud.Student.Management.entity.Student;
import com.stud.Student.Management.entity.Academy;
import com.stud.Student.Management.entity.Course;
import com.stud.Student.Management.mapper.Mapper;
import com.stud.Student.Management.repository.StudentRepository;
import com.stud.Student.Management.repository.AcademyRepository;
import com.stud.Student.Management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AcademyRepository academyRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Academy academy = null;
        if (studentDTO.getAcademyId() != null) {
            academy = academyRepository.findById(studentDTO.getAcademyId()).orElse(null);
        }
        Set<Course> courses = new HashSet<>();
        if (studentDTO.getCourses() != null) {
            for (Course c : studentDTO.getCourses()) {
                if (c.getId() != null) {
                    courseRepository.findById(c.getId()).ifPresent(courses::add);
                }
            }
        }
        Student student = Mapper.toStudent(studentDTO, academy, courses);
        Student saved = studentRepository.save(student);
        return Mapper.toStudentDTO(saved);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(Mapper::toStudentDTO).orElse(null);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());
            student.setDob(studentDTO.getDob());
            if (studentDTO.getAcademyId() != null) {
                Academy academy = academyRepository.findById(studentDTO.getAcademyId()).orElse(null);
                student.setAcademy(academy);
            }
            Set<Course> courses = new HashSet<>();
            if (studentDTO.getCourses() != null) {
                for (Course c : studentDTO.getCourses()) {
                    if (c.getId() != null) {
                        courseRepository.findById(c.getId()).ifPresent(courses::add);
                    }
                }
            }
            student.setCourses(courses);
            Student updated = studentRepository.save(student);
            return Mapper.toStudentDTO(updated);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
