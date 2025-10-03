package com.dam2.model;

public class ModulProfessional {
    private int id;
    private String nom;
    private Professor professor; // pot ser null

    public ModulProfessional() {}

    public ModulProfessional(String nom, Professor professor) {
        this.nom = nom;
        this.professor = professor;
    }

    public ModulProfessional(int id, String nom, Professor professor) {
        this.id = id;
        this.nom = nom;
        this.professor = professor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    @Override
    public String toString() {
        String profText = (professor == null) ? "Sense professor" : professor.toString();
        return id + " - " + nom + " (Professor: " + profText + ")";
    }
}
