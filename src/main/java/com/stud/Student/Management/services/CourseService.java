package com.stud.Student.Management.services;

import com.stud.Student.Management.dto.CourseDTO;

public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);
    CourseDTO getCourseById(Long id);
    CourseDTO updateCourse(Long id, CourseDTO courseDTO);
    void deleteCourse(Long id);
}
