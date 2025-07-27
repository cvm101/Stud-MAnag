package com.stud.Student.Management.controller;

import com.stud.Student.Management.dto.AcademyDTO;
import com.stud.Student.Management.services.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academies")
public class AcademyController {
    @Autowired
    private AcademyService academyService;

    @PostMapping
    public ResponseEntity<AcademyDTO> createAcademy(@RequestBody AcademyDTO academyDTO) {
        return ResponseEntity.ok(academyService.createAcademy(academyDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademyDTO> getAcademyById(@PathVariable Long id) {
        AcademyDTO dto = academyService.getAcademyById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademyDTO> updateAcademy(@PathVariable Long id, @RequestBody AcademyDTO academyDTO) {
        AcademyDTO updated = academyService.updateAcademy(id, academyDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademy(@PathVariable Long id) {
        academyService.deleteAcademy(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AcademyDTO>> getAllAcademies() {
        return ResponseEntity.ok(academyService.getAllAcademies());
    }
}
