package com.example.lab5.controller;

import com.example.lab5.entity.Carti;
import com.example.lab5.entity.Recenzii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lab5.service.RecenziiService;
import java.util.List;

@RestController
@RequestMapping("/recenzii")
public class RecenziiController {

    @Autowired
    private RecenziiService recenziiService;

    @GetMapping
    public ResponseEntity<List<Recenzii>> getAllRecenzii() {
        List<Recenzii> recenziiList = recenziiService.findAll();
        return new ResponseEntity<>(recenziiList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recenzii> getRecenzieById(@PathVariable int id) {
        Recenzii recenzie = recenziiService.findById(id);
        return new ResponseEntity<>(recenzie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Recenzii> createRecenzie(@RequestBody Recenzii recenzie) {
        recenziiService.create(recenzie);
        return new ResponseEntity<>(recenzie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recenzii> updateRecenzie(@PathVariable int id, @RequestBody Recenzii recenzie) {
        if (recenziiService.existsById(id)) {
            recenziiService.update(id, recenzie);
            return new ResponseEntity<>(recenzie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecenzie(@PathVariable int id) {
        if (recenziiService.existsById(id)) {
            recenziiService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}