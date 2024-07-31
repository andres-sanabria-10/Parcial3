package com.example.Parcial3.repositories;

import com.example.Parcial3.model.Academic_semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import  com.example.Parcial3.model.PracticalIntersectionCompany;

import java.util.List;

@Repository
public interface Academic_semesterRepository extends JpaRepository<Academic_semester, Integer> {


    @Query("SELECT as.name as semesterName, m.name as matterName, " +
            "t.name as teacherName, t.lastName as teacherLastName, " +
            "p.startDate, p.endDate, p.location " +
            "FROM Academic_semester as " +
            "JOIN as.matter m " +
            "JOIN as.teacher t " +
            "JOIN m.practice p " +
            "WHERE as.id = :semesterId")
    static List<Object[]> findPracticesSummaryBySemester(@Param("semesterId") Integer semesterId);

}
