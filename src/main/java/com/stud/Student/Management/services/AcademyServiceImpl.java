package com.stud.Student.Management.services;

import com.stud.Student.Management.dto.AcademyDTO;
import com.stud.Student.Management.entity.Academy;
import com.stud.Student.Management.mapper.Mapper;
import com.stud.Student.Management.repository.AcademyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AcademyServiceImpl implements AcademyService {
    @Autowired
    private AcademyRepository academyRepository;

    @Override
    public AcademyDTO createAcademy(AcademyDTO academyDTO) {
        Academy academy = Mapper.toAcademy(academyDTO);
        Academy saved = academyRepository.save(academy);
        return Mapper.toAcademyDTO(saved);
    }

    @Override
    public AcademyDTO getAcademyById(Long id) {
        Optional<Academy> academy = academyRepository.findById(id);
        return academy.map(Mapper::toAcademyDTO).orElse(null);
    }

    @Override
    public AcademyDTO updateAcademy(Long id, AcademyDTO academyDTO) {
        Optional<Academy> optionalAcademy = academyRepository.findById(id);
        if (optionalAcademy.isPresent()) {
            Academy academy = optionalAcademy.get();
            academy.setAcademyName(academyDTO.getAcademyName());
            academy.setLocation(academyDTO.getLocation());
            Academy updated = academyRepository.save(academy);
            return Mapper.toAcademyDTO(updated);
        }
        return null;
    }

    @Override
    public void deleteAcademy(Long id) {
        academyRepository.deleteById(id);
    }

    @Override
    public List<AcademyDTO> getAllAcademies() {
        return academyRepository.findAll().stream()
                .map(Mapper::toAcademyDTO)
                .collect(Collectors.toList());
    }
}
