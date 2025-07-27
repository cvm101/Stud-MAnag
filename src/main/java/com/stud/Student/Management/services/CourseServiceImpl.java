package com.stud.Student.Management.services;

import com.stud.Student.Management.dto.CourseDTO;
import com.stud.Student.Management.entity.Course;
import com.stud.Student.Management.mapper.Mapper;
import com.stud.Student.Management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = Mapper.toCourse(courseDTO);
        Course saved = courseRepository.save(course);
        return Mapper.toCourseDTO(saved);
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(Mapper::toCourseDTO).orElse(null);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.setCourseName(courseDTO.getCourseName());
            course.setDescription(courseDTO.getDescription());
            course.setCredit(courseDTO.getCredit());
            Course updated = courseRepository.save(course);
            return Mapper.toCourseDTO(updated);
        }
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
