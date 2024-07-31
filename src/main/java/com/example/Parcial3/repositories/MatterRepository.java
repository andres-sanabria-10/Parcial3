package com.example.Parcial3.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import  com.example.Parcial3.model.Matter;

import java.util.List;

public interface MatterRepository extends JpaRepository<Matter, Integer> {
    List<Matter> findByPracticeId(Integer practiceId);
}
