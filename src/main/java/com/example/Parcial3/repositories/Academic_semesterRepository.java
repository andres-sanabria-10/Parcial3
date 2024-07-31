package com.example.Parcial3.repositories;

import com.example.Parcial3.model.Academic_semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import  com.example.Parcial3.model.PracticalIntersectionCompany;

@Repository
public interface Academic_semesterRepository extends JpaRepository<Academic_semester, Integer> {
}
