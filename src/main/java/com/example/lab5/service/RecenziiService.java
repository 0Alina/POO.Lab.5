package com.example.lab5.service;

import com.example.lab5.entity.Recenzii;
import com.example.lab5.repository.RecenziiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecenziiService {

    @Autowired
    private RecenziiRepository recenziiRepository;

    public List<Recenzii> findAll() {
        return recenziiRepository.findAll();
    }

    public Recenzii findById(int id) {
        return recenziiRepository.findById(id);
    }

    public void create(Recenzii recenzie) {
        recenziiRepository.create(recenzie);
    }

    public void update(int id, Recenzii recenzie) {
        recenziiRepository.update(id, recenzie);
    }

    public void delete(int id) {
        recenziiRepository.delete(id);
    }

    public boolean existsById(int id) {
        return recenziiRepository.existById(id);
    }
}
