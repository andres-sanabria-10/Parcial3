package com.example.Parcial3.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Matter implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 40)
    private String NumCredit;


    @OneToMany(mappedBy = "matter", cascade = CascadeType.ALL)
    private List<Academic_semester> academic_semesters;

    @ManyToOne
    @JoinColumn(name = "practice_id")
    private Practice practice;




    public Matter() {
    }


    public Matter(Integer id, String name, String numCredit) {
        this.id = id;
        this.name = name;
        NumCredit = numCredit;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumCredit() {
        return NumCredit;
    }

    public void setNumCredit(String numCredit) {
        NumCredit = numCredit;
    }
}
