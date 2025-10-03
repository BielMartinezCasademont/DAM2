package com.dam2.controller;

import com.dam2.dao.ProfessorDAO;
import com.dam2.model.Professor;

import java.util.List;
import java.util.Scanner;

public class ProfessorController {
    private final ProfessorDAO dao = new ProfessorDAO();

    public void create(Scanner sc) {
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.print("Cognoms: ");
        String cognoms = sc.nextLine();
        Professor p = new Professor(nom, cognoms);
        dao.addDam2(p);
        System.out.println("Afegit: " + p);
    }

    public void list() {
        List<Professor> l = dao.readDam2();
        if (l.isEmpty()) System.out.println("No hi ha professors.");
        else l.forEach(System.out::println);
    }

    public void update(Scanner sc) {
        System.out.print("ID del professor a actualitzar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nou nom: ");
        String nom = sc.nextLine();
        System.out.print("Nous cognoms: ");
        String cognoms = sc.nextLine();
        Professor p = new Professor(id, nom, cognoms);
        boolean ok = dao.updateDam2(p);
        System.out.println(ok ? "Actualitzat correctament." : "No s'ha pogut actualitzar.");
    }

    public void delete(Scanner sc) {
        System.out.print("ID del professor a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean ok = dao.deleteDam2(id);
        System.out.println(ok ? "Eliminat correctament." : "No s'ha pogut eliminar.");
    }
}

