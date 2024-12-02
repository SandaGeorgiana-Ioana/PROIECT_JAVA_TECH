package com.example.proiect;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Notificare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mesaj;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Utilizator utilizator;

    public Notificare() {
    }

    public Notificare(String mesaj, Date data, Utilizator utilizator) {
        this.mesaj = mesaj;
        this.data = data;
        this.utilizator = utilizator;
    }

    public void trimiteNotificare() {
        System.out.println("Notificare trimisă către " + utilizator.getNume() + ": " + mesaj);
    }

    // Getters și setters
}
