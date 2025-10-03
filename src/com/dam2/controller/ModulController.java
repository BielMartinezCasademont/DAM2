package com.dam2.controller;

import com.dam2.dao.ModulDAO;
import com.dam2.dao.ProfessorDAO;
import com.dam2.model.ModulProfessional;
import com.dam2.model.Professor;

import java.util.List;
import java.util.Scanner;
import java.util.Scanner;

public class ModulController {
    private final ModulDAO dao = new ModulDAO();
    private final ProfessorDAO profDao = new ProfessorDAO();

    public void create(Scanner sc) {
        System.out.print("Nom del mòdul: ");
        String nom = sc.nextLine();
        System.out.println("Tria ID professor (o 0 per cap):");
        List<Professor> profs = profDao.readDam2();
        profs.forEach(System.out::println);
        System.out.print("ID professor (0 = cap): ");
        int pid = Integer.parseInt(sc.nextLine());
        Professor p = null;
        if (pid != 0) {
            p = profs.stream().filter(x -> x.getId() == pid).findFirst().orElse(null);
            if (p == null) {
                System.out.println("ID professor no trobat. Assignant cap.");
            }
        }
        ModulProfessional m = new ModulProfessional(nom, p);
        dao.addDam2(m);
        System.out.println("Afegit: " + m);
    }

    public void list() {
        List<ModulProfessional> l = dao.readDam2();
        if (l.isEmpty()) System.out.println("No hi ha mòduls.");
        else l.forEach(System.out::println);
    }

    public void update(Scanner sc) {
        System.out.print("ID del mòdul a actualitzar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nou nom: ");
        String nom = sc.nextLine();
        System.out.println("Tria ID professor (o 0 per cap):");
        List<Professor> profs = profDao.readDam2();
        profs.forEach(System.out::println);
        System.out.print("ID professor (0 = cap): ");
        int pid = Integer.parseInt(sc.nextLine());
        Professor p = null;
        if (pid != 0) {
            p = profs.stream().filter(x -> x.getId() == pid).findFirst().orElse(null);
            if (p == null) System.out.println("ID professor no trobat. Assignant cap.");
        }
        ModulProfessional m = new ModulProfessional(id, nom, p);
        boolean ok = dao.updateDam2(m);
        System.out.println(ok ? "Actualitzat correctament." : "No s'ha pogut actualitzar.");
    }

    public void delete(Scanner sc) {
        System.out.print("ID del mòdul a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean ok = dao.deleteDam2(id);
        System.out.println(ok ? "Eliminat correctament." : "No s'ha pogut eliminar.");
    }
}

