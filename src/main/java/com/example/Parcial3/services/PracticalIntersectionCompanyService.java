package com.example.Parcial3.services;

import com.example.Parcial3.model.PracticalIntersectionCompany;
import com.example.Parcial3.repositories.PracticalIntersectionCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticalIntersectionCompanyService {

    @Autowired
    private PracticalIntersectionCompanyRepository repository;

    public List<PracticalIntersectionCompany> getAllPracticalIntersectionCompanies() {
        return repository.findAll();
    }

    public Optional<PracticalIntersectionCompany> getPracticalIntersectionCompanyById(Integer id) {
        return repository.findById(id);
    }

    public PracticalIntersectionCompany savePracticalIntersectionCompany(PracticalIntersectionCompany company) {
        return repository.save(company);
    }

    public void deletePracticalIntersectionCompany(Integer id) {
        repository.deleteById(id);
    }

    public PracticalIntersectionCompany updatePracticalIntersectionCompany(Integer id, PracticalIntersectionCompany companyDetails) {
        PracticalIntersectionCompany company = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PracticalIntersectionCompany not found with id: " + id));

        company.setDate(companyDetails.getDate());
        // Aquí puedes actualizar más campos si es necesario

        return repository.save(company);
    }
}