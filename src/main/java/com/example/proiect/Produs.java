package com.example.proiect;
import jakarta.persistence.*;

public class Produs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;
    private double pret;
    private String descriere;

    public Produs() {
    }

    public Produs(String nume, double pret, String descriere) {
        this.nume = nume;
        this.pret = pret;
        this.descriere = descriere;
    }

    public String getDescriere() {
        return descriere;
    }

    public double getPret() {
        return pret;
    }

    public String getNume() {
        return nume;
    }

    public Long getId() {
        return id;
    }


}
