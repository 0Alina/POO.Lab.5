package com.example.lab5.entity;

import java.util.Objects;

public class Carti {
    private Long idCarte;
    private String titlu;
    private int idAutor;
    private int anPublicatie;
    private String gen;

    public Carti() {
    }

    public Carti(Long idCarte, String titlu, int idAutor, int anPublicatie, String gen) {
        this.idCarte = idCarte;
        this.titlu = titlu;
        this.idAutor = idAutor;
        this.anPublicatie = anPublicatie;
        this.gen = gen;
    }

    public Long getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(Long idCarte) {
        this.idCarte = idCarte;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getAnPublicatie() {
        return anPublicatie;
    }

    public void setAnPublicatie(int anPublicatie) {
        this.anPublicatie = anPublicatie;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Carti carti = (Carti) o;

        if (!Objects.equals(idCarte, carti.idCarte)) {
            return false;
        }
        if (!Objects.equals(titlu, carti.titlu)) {
            return false;
        }
        if (idAutor != carti.idAutor) {
            return false;
        }
        if (anPublicatie != carti.anPublicatie) {
            return false;
        }
        return Objects.equals(gen, carti.gen);
    }

    @Override
    public int hashCode() {
        int result = idCarte != null ? idCarte.hashCode() : 0;
        result = 31 * result + (titlu != null ? titlu.hashCode() : 0);
        result = 31 * result + idAutor;
        result = 31 * result + anPublicatie;
        result = 31 * result + (gen != null ? gen.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Carti{" +
                "idCarte=" + idCarte +
                ", titlu='" + titlu + '\'' +
                ", idAutor=" + idAutor +
                ", anPublicatie=" + anPublicatie +
                ", gen='" + gen + '\'' +
                '}';
    }
}

