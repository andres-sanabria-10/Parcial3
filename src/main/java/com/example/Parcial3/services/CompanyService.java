package com.example.Parcial3.services;

import com.example.Parcial3.model.Company;
import com.example.Parcial3.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Integer id) {
        return companyRepository.findById(id);
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }

    public Company updateCompany(Integer id, Company companyDetails) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            Company existingCompany = company.get();
            existingCompany.setName(companyDetails.getName());
            existingCompany.setNit(companyDetails.getNit());
            return companyRepository.save(existingCompany);
        }
        return null;
    }

}