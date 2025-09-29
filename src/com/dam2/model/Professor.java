package com.dam2.model;

public class Professor {
    private int id;
    private String nom;
    private String cognoms;

    public Professor() {}

    public Professor(String nom, String cognoms) {
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public Professor(int id, String nom, String cognoms) {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getCognoms() { return cognoms; }
    public void setCognoms(String cognoms) { this.cognoms = cognoms; }

    @Override
    public String toString() {
        return id + " - " + nom + " " + cognoms;
    }
}
