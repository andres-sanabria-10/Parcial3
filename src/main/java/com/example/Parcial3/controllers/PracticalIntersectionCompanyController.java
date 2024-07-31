package com.example.Parcial3.controllers;

import com.example.Parcial3.model.PracticalIntersectionCompany;
import com.example.Parcial3.services.PracticalIntersectionCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practical-intersection-companies")
public class PracticalIntersectionCompanyController {

    @Autowired
    private PracticalIntersectionCompanyService service;

    @GetMapping
    public ResponseEntity<List<PracticalIntersectionCompany>> getAllPracticalIntersectionCompanies() {
        try {
            List<PracticalIntersectionCompany> companies = service.getAllPracticalIntersectionCompanies();
            return new ResponseEntity<>(companies, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PracticalIntersectionCompany> getPracticalIntersectionCompanyById(@PathVariable Integer id) {
        try {
            return service.getPracticalIntersectionCompanyById(id)
                    .map(company -> new ResponseEntity<>(company, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<PracticalIntersectionCompany> createPracticalIntersectionCompany(@RequestBody PracticalIntersectionCompany company) {
        try {
            PracticalIntersectionCompany savedCompany = service.savePracticalIntersectionCompany(company);
            return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PracticalIntersectionCompany> updatePracticalIntersectionCompany(@PathVariable Integer id, @RequestBody PracticalIntersectionCompany companyDetails) {
        try {
            PracticalIntersectionCompany updatedCompany = service.updatePracticalIntersectionCompany(id, companyDetails);
            if (updatedCompany != null) {
                return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePracticalIntersectionCompany(@PathVariable Integer id) {
        try {
            service.deletePracticalIntersectionCompany(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
