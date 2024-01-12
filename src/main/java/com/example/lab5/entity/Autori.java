package com.example.lab5.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Objects;


public class Autori {

    private int id;
    private String numeAutor;
    private String origine;

    public Autori(int id, String numeAutor, String origine) {
        this.id = id;
        this.numeAutor = numeAutor;
        this.origine = origine;
    }

    public Autori() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeAutor() {
        return numeAutor;
    }

    public void setNumeAutor(String numeAutor) {
        this.numeAutor = numeAutor;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Autori autori = (Autori) o;

        if (id != autori.id) {
            return false;
        }
        if (!Objects.equals(numeAutor, autori.numeAutor)) {
            return false;
        }
        return Objects.equals(origine, autori.origine);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (numeAutor != null ? numeAutor.hashCode() : 0);
        result = 31 * result + (origine != null ? origine.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Autori{" +
                "idAutor=" + id +
                ", numeAutor='" + numeAutor + '\'' +
                ", origine='" + origine + '\'' +
                '}';
    }
}
