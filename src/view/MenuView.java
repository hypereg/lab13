package view;

import controller.WorkerController;
import model.Dyrektor;
import model.Handlowiec;
import model.Pracownik;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuView {
    private final Scanner scanner = new Scanner(System.in);
    private WorkerView workerView;
    private BackupView backupView;

    public MenuView(WorkerView workerView, BackupView backupView) {
        this.workerView = workerView;
        this.backupView = backupView;
    }
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
                    workerView.listEmployees();
                    break;
                case 2:
                    workerView.addEmployee();
                    break;
                case 3:
                    workerView.removeEmployee();
                    break;
                case 4:
                    backupView.backupMenu();
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
            }
        }
    }

}