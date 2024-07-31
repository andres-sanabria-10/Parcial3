package com.example.Parcial3.controllers;

import com.example.Parcial3.model.Matter;
import com.example.Parcial3.services.MatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/matters")
public class MatterController {

    @Autowired
    private MatterService matterService;

    @GetMapping
    public ResponseEntity<List<Matter>> getAllMatters() {
        List<Matter> matters = matterService.findAll();
        return ResponseEntity.ok(matters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matter> getMatterById(@PathVariable Integer id) {
        Matter matter = matterService.findById(id);
        if (matter != null) {
            return ResponseEntity.ok(matter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{idPractice}")
    public ResponseEntity<Matter> createMatter(@PathVariable Integer idPractice, @RequestBody Matter matter) {
        try {
            Matter savedMatter = matterService.save(matter, idPractice);
            if (savedMatter != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(savedMatter);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matter> updateMatter(@PathVariable Integer id, @RequestBody Matter matterDetails) {
        try {
            Matter updatedMatter = matterService.update(id, matterDetails);
            if (updatedMatter != null) {
                return ResponseEntity.ok(updatedMatter);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatter(@PathVariable Integer id) {
        boolean deleted = matterService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/practice/{practiceId}")
    public ResponseEntity<List<Matter>> getMattersByPracticeId(@PathVariable Integer practiceId) {
        List<Matter> matters = matterService.findAllByPracticeId(practiceId);
        return ResponseEntity.ok(matters);
    }
}