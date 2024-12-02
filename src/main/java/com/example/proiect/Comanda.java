package com.example.proiect;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataComenzii;
    private double sumaTotala;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Utilizator utilizator;
    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ElementCos> elementeCos;

    public Comanda() {
    }

    public Comanda(Utilizator utilizator, double sumaTotala, List<ElementCos> elementeCos) {
        this.utilizator = utilizator;
        this.sumaTotala = sumaTotala;
        this.elementeCos = elementeCos;
        this.dataComenzii = new Date();
    }

    public Date getDataComenzii() {
        return dataComenzii;
    }

    public void setDataComenzii(Date dataComenzii) {
        this.dataComenzii = dataComenzii;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSumaTotala() {
        return sumaTotala;
    }

    public void setSumaTotala(double sumaTotala) {
        this.sumaTotala = sumaTotala;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public List<ElementCos> getElementeCos() {
        return elementeCos;
    }

    public void setElementeCos(List<ElementCos> elementeCos) {
        this.elementeCos = elementeCos;
    }
}
