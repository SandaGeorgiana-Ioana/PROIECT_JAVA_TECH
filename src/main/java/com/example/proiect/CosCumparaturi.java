package com.example.proiect;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CosCumparaturi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Utilizator utilizator;
    @OneToMany(mappedBy = "cosCumparaturi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ElementCos> elementeCos = new ArrayList<>();

    public CosCumparaturi() {
    }

    public CosCumparaturi(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public void adaugaProdus(Produs produs, int cantitate) {
        ElementCos elementCos = new ElementCos(produs, cantitate, this);
        elementeCos.add(elementCos);
    }

    // Getters și setters
}
