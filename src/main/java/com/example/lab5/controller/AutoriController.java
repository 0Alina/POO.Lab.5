package com.example.lab5.controller;

import com.example.lab5.entity.Autori;
import com.example.lab5.entity.Carti;
import com.example.lab5.entity.Recenzii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lab5.service.AutoriService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5432")
@RestController
@RequestMapping("/autori")
public class AutoriController {

    @Autowired
    private AutoriService autoriService;

    @GetMapping
    public ResponseEntity<List<Autori>> getAllAutori() {
        List<Autori> autoriList = autoriService.findAll();
        return new ResponseEntity<>(autoriList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autori> getAutorById(@PathVariable int id) {
        Autori autor = autoriService.findById(id);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Autori> createAutor(@RequestBody Autori autor) {
        autoriService.create(autor);
        return new ResponseEntity<>(autor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autori> updateAutor(@PathVariable int id, @RequestBody Autori autor) {
        if (autoriService.existsById(id)) {
            autoriService.update(id, autor);
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable int id) {
        if (autoriService.existsById(id)) {
            autoriService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
