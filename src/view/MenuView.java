package view;

import model.Dyrektor;
import model.Handlowiec;
import model.Pracownik;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("MENU");
            System.out.println("   1. Lista pracowników");
            System.out.println("   2. Dodaj pracownika");
            System.out.println("   3. Usuń pracownika");
            System.out.println("   4. Kopia zapasowa");
            System.out.print("Wybór> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listEmployees();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    backupMenu();
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
            }
        }
    }



    private void backupMenu() {}
}