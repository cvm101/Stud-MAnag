package com.stud.Student.Management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String description;
    private float credit;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

}
