package com.dam2.app;

import com.dam2.controller.ProfessorController;
import com.dam2.controller.ModulController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProfessorController pc = new ProfessorController();
        ModulController mc = new ModulController();

        while (true) {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Gestionar professors");
            System.out.println("2. Gestionar mòduls professionals");
            System.out.println("0. Sortir");
            System.out.print("Triar opció: ");
            String opc = sc.nextLine();
            if (opc.equals("0")) break;

            switch (opc) {
                case "1":
                    gestionarProfessors(sc, pc);
                    break;
                case "2":
                    gestionarModuls(sc, mc);
                    break;
                default:
                    System.out.println("Opció invàlida.");
            }
        }
        sc.close();
        System.out.println("Fins aviat!");
    }

    private static void gestionarProfessors(Scanner sc, ProfessorController pc) {
        while (true) {
            System.out.println("--- PROFESSORS ---");
            System.out.println("1. Alta");
            System.out.println("2. Llistar");
            System.out.println("3. Actualitzar");
            System.out.println("4. Eliminar");
            System.out.println("0. Tornar");
            System.out.print("Triar opció: ");
            String op = sc.nextLine();
            if (op.equals("0")) break;
            switch (op) {
                case "1": pc.create(sc); break;
                case "2": pc.list(); break;
                case "3": pc.update(sc); break;
                case "4": pc.delete(sc); break;
                default: System.out.println("Opció invàlida.");
            }
        }
    }

    private static void gestionarModuls(Scanner sc, ModulController mc) {
        while (true) {
            System.out.println("--- MODULS PROFESSIONALS ---");
            System.out.println("1. Alta");
            System.out.println("2. Llistar");
            System.out.println("3. Actualitzar");
            System.out.println("4. Eliminar");
            System.out.println("0. Tornar");
            System.out.print("Triar opció: ");
            String op = sc.nextLine();
            if (op.equals("0")) break;
            switch (op) {
                case "1": mc.create(sc); break;
                case "2": mc.list(); break;
                case "3": mc.update(sc); break;
                case "4": mc.delete(sc); break;
                default: System.out.println("Opció invàlida.");
            }
        }
    }
}