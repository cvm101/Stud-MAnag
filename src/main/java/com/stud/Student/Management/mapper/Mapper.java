package com.stud.Student.Management.mapper;

import com.stud.Student.Management.entity.Student;
import com.stud.Student.Management.entity.Course;
import com.stud.Student.Management.entity.Academy;
import com.stud.Student.Management.dto.StudentDTO;
import com.stud.Student.Management.dto.CourseDTO;
import com.stud.Student.Management.dto.AcademyDTO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapper {
    public static StudentDTO toStudentDTO(Student student) {
        if (student == null) return null;
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setDob(student.getDob());
        dto.setAcademy(toAcademyDTO(student.getAcademy()));
        dto.setAcademyId(student.getAcademy() != null ? student.getAcademy().getId() : null);
        dto.setCourses(student.getCourses() != null ? List.copyOf(student.getCourses()) : null);
        // Optionally map one course if needed
        // dto.setCourse(...);
        // dto.setCourseId(...);
        return dto;
    }

    public static Student toStudent(StudentDTO dto, Academy academy, Set<Course> courses) {
        if (dto == null) return null;
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setDob(dto.getDob());
        student.setAcademy(academy);
        student.setCourses(courses);
        return student;
    }

    public static CourseDTO toCourseDTO(Course course) {
        if (course == null) return null;
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setCourseName(course.getCourseName());
        dto.setDescription(course.getDescription());
        dto.setCredit(course.getCredit());
        return dto;
    }

    public static Course toCourse(CourseDTO dto) {
        if (dto == null) return null;
        Course course = new Course();
        course.setId(dto.getId());
        course.setCourseName(dto.getCourseName());
        course.setDescription(dto.getDescription());
        course.setCredit(dto.getCredit());
        return course;
    }

    public static AcademyDTO toAcademyDTO(Academy academy) {
        if (academy == null) return null;
        AcademyDTO dto = new AcademyDTO();
        dto.setId(academy.getId());
        dto.setAcademyName(academy.getAcademyName());
        dto.setLocation(academy.getLocation());
        return dto;
    }

    public static Academy toAcademy(AcademyDTO dto) {
        if (dto == null) return null;
        Academy academy = new Academy();
        academy.setId(dto.getId());
        academy.setAcademyName(dto.getAcademyName());
        academy.setLocation(dto.getLocation());
        return academy;
    }

    public static List<CourseDTO> toCourseDTOList(Set<Course> courses) {
        if (courses == null) return null;
        return courses.stream().map(Mapper::toCourseDTO).collect(Collectors.toList());
    }

    public static Set<Course> toCourseSet(List<CourseDTO> dtos) {
        if (dtos == null) return null;
        return dtos.stream().map(Mapper::toCourse).collect(Collectors.toSet());
    }
}