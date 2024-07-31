package com.example.Parcial3.controllers;

import com.example.Parcial3.model.Academic_semester;
import com.example.Parcial3.services.Academic_semesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic-semesters")
public class Academic_semesterController {

    @Autowired
    private Academic_semesterService academicSemesterService;

    @GetMapping
    public List<Academic_semester> getAllAcademicSemesters() {
        return academicSemesterService.getAllAcademicSemesters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Academic_semester> getAcademicSemesterById(@PathVariable Integer id) {
        return academicSemesterService.getAcademicSemesterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{studentId}/{teacherId}/{matterId}")
    public Academic_semester createAcademicSemester(
            @PathVariable Integer studentId,
            @PathVariable Integer teacherId,
            @PathVariable Integer matterId,
            @RequestBody Academic_semester academicSemester) {
        return academicSemesterService.createAcademicSemester(studentId, teacherId, matterId, academicSemester);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Academic_semester> updateAcademicSemester(
            @PathVariable Integer id,
            @RequestBody Academic_semester academicSemesterDetails) {
        Academic_semester updatedAcademicSemester = academicSemesterService.updateAcademicSemester(id, academicSemesterDetails);
        return ResponseEntity.ok(updatedAcademicSemester);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAcademicSemester(@PathVariable Integer id) {
        academicSemesterService.deleteAcademicSemester(id);
        return ResponseEntity.ok().build();
    }
}