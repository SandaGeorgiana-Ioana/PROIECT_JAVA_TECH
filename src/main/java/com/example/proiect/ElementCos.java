package com.example.proiect;

import jakarta.persistence.*;

@Entity
public class ElementCos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produs_id", nullable = false)
    private Produs produs;
    private int cantitate;
    @ManyToOne
    @JoinColumn(name = "comanda_id", nullable = false)
    private Comanda comanda;

    public ElementCos(Produs produs, int cantitate, CosCumparaturi cosCumparaturi) {
    }

    public ElementCos(Produs produs, int cantitate, Comanda comanda) {
        this.produs = produs;
        this.cantitate = cantitate;
        this.comanda = comanda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
}
