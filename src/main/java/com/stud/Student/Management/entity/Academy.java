package com.stud.Student.Management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "academies")
public class Academy {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;


    private String AcademyName;

    private String Location;

    @OneToMany(mappedBy = "academy", cascade = CascadeType.ALL)
    List<Student> students = new ArrayList<>();


}
