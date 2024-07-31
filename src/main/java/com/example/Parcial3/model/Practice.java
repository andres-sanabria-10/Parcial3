package com.example.Parcial3.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Practice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false,length =50)
    private LocalDate startDate;

    @Column(nullable = false,length =50)
    private LocalDate endDate;

    @Column(nullable = false,length =50)
    private String location;

    @OneToMany()
    private List<Matter> MatterList;

    public Practice() {

    }

    public Practice(Integer id, LocalDate startDate, LocalDate endDate, String location) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
