package com.example.lab5.controller;

import com.example.lab5.entity.Carti;
import com.example.lab5.entity.Recenzii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lab5.service.CartiService;
import java.util.List;

@RestController
@RequestMapping("/carti")
public class CartiController {

    @Autowired
    private CartiService cartiService;

    @GetMapping
    public ResponseEntity<List<Carti>> getAllCarti() {
        List<Carti> cartiList = cartiService.findAll();
        return new ResponseEntity<>(cartiList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carti> getCarteById(@PathVariable Long id) {
        Carti carte = cartiService.findById(id);
        return new ResponseEntity<>(carte, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Carti> createCarte(@RequestBody Carti carte) {
        cartiService.create(carte);
        return new ResponseEntity<>(carte, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carti> updateCarte(@PathVariable Long id, @RequestBody Carti carte) {
        if (cartiService.existsById(id)) {
            cartiService.update(id, carte);
            return new ResponseEntity<>(carte, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarte(@PathVariable Long id) {
        if (cartiService.existsById(id)) {
            cartiService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}