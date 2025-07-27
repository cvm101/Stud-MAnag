package com.stud.Student.Management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

//    private String Address;

    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "academy_id", nullable = true)
    private Academy academy;

    @ManyToMany
    @JoinTable(
        name = "student_courser",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();



}
