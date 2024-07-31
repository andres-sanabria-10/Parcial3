package com.example.Parcial3.services;

import com.example.Parcial3.model.PracticalIntersectionCompany;
import com.example.Parcial3.repositories.PracticalIntersectionCompanyRepository;
import com.example.Parcial3.repositories.CompanyRepository;
import com.example.Parcial3.repositories.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticalIntersectionCompanyService {

    @Autowired
    private PracticalIntersectionCompanyRepository picRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PracticeRepository practiceRepository;

    public List<PracticalIntersectionCompany> getAllPracticalIntersectionCompanies() {
        return picRepository.findAll();
    }

    public Optional<PracticalIntersectionCompany> getPracticalIntersectionCompanyById(Integer id) {
        return picRepository.findById(id);
    }

    public PracticalIntersectionCompany createPracticalIntersectionCompany(Integer companyId, Integer practiceId, PracticalIntersectionCompany pic) {
        return companyRepository.findById(companyId).map(company -> {
            pic.setCompany(company);
            return practiceRepository.findById(practiceId).map(practice -> {
                pic.setPractice(practice);
                return picRepository.save(pic);
            }).orElseThrow(() -> new RuntimeException("Practice not found"));
        }).orElseThrow(() -> new RuntimeException("Company not found"));
    }

    public PracticalIntersectionCompany updatePracticalIntersectionCompany(Integer id, PracticalIntersectionCompany picDetails) {
        return picRepository.findById(id).map(pic -> {
            pic.setDate(picDetails.getDate());
            return picRepository.save(pic);
        }).orElseThrow(() -> new RuntimeException("PracticalIntersectionCompany not found"));
    }

    public void deletePracticalIntersectionCompany(Integer id) {
        picRepository.deleteById(id);
    }
}