package com.example.Parcial3.controllers;

import com.example.Parcial3.model.Practice;
import com.example.Parcial3.model.Student;
import com.example.Parcial3.services.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/practices")
@CrossOrigin(origins = "http://localhost:3200")
public class PracticeController {

    private final PracticeService practiceService;

    @Autowired
    public PracticeController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    @GetMapping
    public ResponseEntity<List<Practice>> getAllPractices() {
        try {
            List<Practice> practices = practiceService.getAllPractices();
            return new ResponseEntity<>(practices, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{practiceId}/students")
    public ResponseEntity<List<Student>> getStudentsByPracticeId(@PathVariable Integer practiceId) {
        List<Student> students = practiceService.getStudentsByPracticeId(practiceId);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practice> getPracticeById(@PathVariable Integer id) {
        try {
            Optional<Practice> practice = practiceService.getPracticeById(id);
            return practice.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Practice> createPractice(@RequestBody Practice practice) {
        try {
            Practice savedPractice = practiceService.savePractice(practice);
            return new ResponseEntity<>(savedPractice, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practice> updatePractice(@PathVariable Integer id, @RequestBody Practice practiceDetails) {
        try {
            Practice updatedPractice = practiceService.updatePractice(id, practiceDetails);
            if (updatedPractice != null) {
                return new ResponseEntity<>(updatedPractice, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePractice(@PathVariable Integer id) {
        try {
            practiceService.deletePractice(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
