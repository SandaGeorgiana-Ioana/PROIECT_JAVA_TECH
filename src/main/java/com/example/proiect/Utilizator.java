package com.example.proiect;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;
    private String parola;
    private String email;
    private boolean autentificare2FA;
    private boolean esteAutentificat;
    @OneToMany(mappedBy = "utilizator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comanda> comenzi = new ArrayList<>();

    public Utilizator() {
    }

    public Utilizator(String nume, String parola, String email) {
        this.nume = nume;
        this.parola = parola;
        this.email = email;
        this.autentificare2FA = false;
        this.esteAutentificat = false;
    }

    public boolean autentifica(String parola, String codUnic) {
        if (this.parola.equals(parola)) {
            if (autentificare2FA) {
                return codUnic != null && codUnic.equals("12345");
            }
            esteAutentificat = true;
            return true;
        }
        return false;
    }

    public void activeazaAutentificare2FA() {
        this.autentificare2FA = true;
    }

    public void dezactiveazaAutentificare2FA() {
        this.autentificare2FA = false;
    }

    public boolean esteAutentificat() {
        return esteAutentificat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAutentificare2FA() {
        return autentificare2FA;
    }

    public void setAutentificare2FA(boolean autentificare2FA) {
        this.autentificare2FA = autentificare2FA;
    }

    public boolean isEsteAutentificat() {
        return esteAutentificat;
    }

    public void setEsteAutentificat(boolean esteAutentificat) {
        this.esteAutentificat = esteAutentificat;
    }

    public List<Comanda> getComenzi() {
        return comenzi;
    }

    public void setComenzi(List<Comanda> comenzi) {
        this.comenzi = comenzi;
    }
}
