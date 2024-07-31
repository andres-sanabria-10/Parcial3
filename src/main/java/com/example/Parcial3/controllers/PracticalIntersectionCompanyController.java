package com.example.Parcial3.controllers;

import com.example.Parcial3.model.PracticalIntersectionCompany;
import com.example.Parcial3.services.PracticalIntersectionCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practical-intersection-companies")
public class PracticalIntersectionCompanyController {

    @Autowired
    private PracticalIntersectionCompanyService picService;

    @GetMapping
    public List<PracticalIntersectionCompany> getAllPracticalIntersectionCompanies() {
        return picService.getAllPracticalIntersectionCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PracticalIntersectionCompany> getPracticalIntersectionCompanyById(@PathVariable Integer id) {
        return picService.getPracticalIntersectionCompanyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{companyId}/{practiceId}")
    public PracticalIntersectionCompany createPracticalIntersectionCompany(
            @PathVariable Integer companyId,
            @PathVariable Integer practiceId,
            @RequestBody PracticalIntersectionCompany pic) {
        return picService.createPracticalIntersectionCompany(companyId, practiceId, pic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PracticalIntersectionCompany> updatePracticalIntersectionCompany(
            @PathVariable Integer id,
            @RequestBody PracticalIntersectionCompany picDetails) {
        PracticalIntersectionCompany updatedPic = picService.updatePracticalIntersectionCompany(id, picDetails);
        return ResponseEntity.ok(updatedPic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePracticalIntersectionCompany(@PathVariable Integer id) {
        picService.deletePracticalIntersectionCompany(id);
        return ResponseEntity.ok().build();
    }
}