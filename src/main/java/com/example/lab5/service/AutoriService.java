package com.example.lab5.service;

import com.example.lab5.entity.Autori;
import com.example.lab5.repository.AutoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoriService {

    @Autowired
    private AutoriRepository autoriRepository;

    public List<Autori> findAll() {
        return autoriRepository.findAll();
    }

    public Autori findById(int id) {
        return autoriRepository.findById(id);
    }

    public void create(Autori autor) {
        autoriRepository.create(autor);
    }

    public void update(int id, Autori autor) {
        autoriRepository.update(id, autor);
    }

    public void delete(int id) {
        autoriRepository.delete(id);
    }

    public boolean existsById(int id) {
        return autoriRepository.existById(id);
    }
}
