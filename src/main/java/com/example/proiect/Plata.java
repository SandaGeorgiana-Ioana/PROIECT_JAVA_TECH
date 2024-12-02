package com.example.proiect;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Plata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double suma;
    private Date dataPlatii;
    private String metodaPlata;
    @ManyToOne
    @JoinColumn(name = "comanda_id", nullable = false)
    private Comanda comanda;

    public Plata() {
    }

    public Plata(Comanda comanda, double suma, String metodaPlata) {
        this.comanda = comanda;
        this.suma = suma;
        this.metodaPlata = metodaPlata;
        this.dataPlatii = new Date();
    }

    // Getters și setters
}
