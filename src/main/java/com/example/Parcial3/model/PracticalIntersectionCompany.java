package com.example.Parcial3.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PracticalIntersectionCompany implements Serializable {
        @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false,length =50)
    private LocalDate Date;

    @OneToMany()
    private List<Practice> practicaInter;

    public PracticalIntersectionCompany() {
    }

    public PracticalIntersectionCompany(Integer id, LocalDate date) {
        this.id = id;
        Date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }
}
