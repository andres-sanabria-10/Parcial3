package com.example.Parcial3.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import  com.example.Parcial3.model.Student;
@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer> {

}
