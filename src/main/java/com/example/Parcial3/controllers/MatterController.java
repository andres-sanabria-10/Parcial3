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
        try {
            List<Matter> matters = matterService.getAllMatters();
            return ResponseEntity.ok(matters);
        } catch (Exception e) {
            // Log the exception (optional)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matter> getMatterById(@PathVariable Integer id) {
        try {
            return matterService.getMatterById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (NoSuchElementException e) {
            // Log the exception (optional)
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // Log the exception (optional)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Matter> createMatter(@RequestBody Matter matter) {
        try {
            Matter savedMatter = matterService.saveMatter(matter);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMatter);
        } catch (Exception e) {
            // Log the exception (optional)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matter> updateMatter(@PathVariable Integer id, @RequestBody Matter matterDetails) {
        try {
            Matter updatedMatter = matterService.updateMatter(id, matterDetails);
            return ResponseEntity.ok(updatedMatter);
        } catch (NoSuchElementException e) {
            // Log the exception (optional)
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // Log the exception (optional)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatter(@PathVariable Integer id) {
        try {
            matterService.deleteMatter(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            // Log the exception (optional)
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // Log the exception (optional)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
