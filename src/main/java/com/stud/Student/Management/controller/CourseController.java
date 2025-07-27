package com.stud.Student.Management.controller;

import com.stud.Student.Management.dto.CourseDTO;
import com.stud.Student.Management.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.createCourse(courseDTO));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        CourseDTO dto = courseService.getCourseById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        CourseDTO updated = courseService.updateCourse(id, courseDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
