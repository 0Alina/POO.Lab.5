package com.example.lab5.entity;

import java.util.Objects;

public class Recenzii {

    private int idRecenzie;
    private int idCarte;
    private int nota;
    private String comentariu;

    public Recenzii() {
    }

    public Recenzii(int idRecenzie, int idCarte, int nota, String comentariu) {
        this.idRecenzie = idRecenzie;
        this.idCarte = idCarte;
        this.nota = nota;
        this.comentariu = comentariu;
    }

    public int getIdRecenzie() {
        return idRecenzie;
    }

    public void setIdRecenzie(int idRecenzie) {
        this.idRecenzie = idRecenzie;
    }

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentariu() {
        return comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Recenzii recenzii = (Recenzii) o;

        if (idRecenzie != recenzii.idRecenzie) {
            return false;
        }
        if (idCarte != recenzii.idCarte) {
            return false;
        }
        if (nota != recenzii.nota) {
            return false;
        }
        return Objects.equals(comentariu, recenzii.comentariu);
    }

    @Override
    public int hashCode() {
        int result = idRecenzie;
        result = 31 * result + idCarte;
        result = 31 * result + nota;
        result = 31 * result + (comentariu != null ? comentariu.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Recenzii{" +
                "idRecenzie=" + idRecenzie +
                ", idCarte=" + idCarte +
                ", nota=" + nota +
                ", comentariu='" + comentariu + '\'' +
                '}';
    }
}
