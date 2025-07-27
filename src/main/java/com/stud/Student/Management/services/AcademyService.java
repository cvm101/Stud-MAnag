package com.stud.Student.Management.services;

import com.stud.Student.Management.dto.AcademyDTO;

import java.util.List;

public interface AcademyService {

    AcademyDTO createAcademy(AcademyDTO academyDTO);
    AcademyDTO getAcademyById(Long id);
    AcademyDTO updateAcademy(Long id, AcademyDTO academyDTO);
    void deleteAcademy(Long id);
    List<AcademyDTO > getAllAcademies();

}
