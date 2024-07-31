package com.example.Parcial3.repositories;
import com.example.Parcial3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import  com.example.Parcial3.model.Practice;
import java.util.List;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, Integer> {

    @Query("SELECT DISTINCT s FROM Student s " +
            "JOIN Academic_semester as_sem ON s.id = as_sem.student.id " +
            "JOIN Matter m ON as_sem.matter.id = m.id " +
            "WHERE m.practice.id = :practiceId")
    List<Student> findStudentsByPracticeId(@Param("practiceId") Integer practiceId);
}
