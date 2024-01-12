package com.example.lab5.service;

import com.example.lab5.entity.Carti;
import com.example.lab5.repository.CartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartiService {

    @Autowired
    private CartiRepository cartiRepository;

    public List<Carti> findAll() {
        return cartiRepository.findAll();
    }

    public Carti findById(Long id) {
        return cartiRepository.findById(id);
    }

    public void create(Carti carte) {
        cartiRepository.create(carte);
    }

    public void update(Long id, Carti carte) {
        cartiRepository.update(id, carte);
    }

    public void delete(Long id) {
        cartiRepository.delete(id);
    }

    public boolean existsById(Long id) {
        return cartiRepository.existById(id);
    }
}
