package com.example.Parcial3.repositories;
 import  com.example.Parcial3.model.PracticalIntersectionCompany;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.stereotype.Repository;

 import java.util.List;

@Repository
public interface PracticalIntersectionCompanyRepository extends JpaRepository<PracticalIntersectionCompany, Integer> {

}
