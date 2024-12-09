package view;

import controller.BackupController;
import controller.WorkerController;

import java.io.IOException;
import java.util.Scanner;

public class BackupView {
    private BackupController backupController;
    private final Scanner scanner = new Scanner(System.in);
    private WorkerController workerController;

    public BackupView(BackupController backupController, WorkerController workerController) {
        this.backupController = backupController;
        this.workerController = workerController;
    }

    public void saveToFile(String fileName, String compression) throws IOException {
        if (compression.equalsIgnoreCase("G")) {
            backupController.saveToGzipFile(workerController.getEmployees(), fileName);
        } else if (compression.equalsIgnoreCase("Z")) {
            backupController.saveToZipFile(workerController.getEmployees(), fileName);
        } else {
            throw new IllegalArgumentException("Nieprawidłowy typ kompresji.");
        }
        System.out.println("Dane zapisane do pliku " + fileName);
    }

    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        if (fileName.endsWith(".gzip")) {
            workerController.setEmployees(backupController.loadFromGzipFile(fileName));
        } else if (fileName.endsWith(".zip")) {
            workerController.setEmployees(backupController.loadFromZipFile(fileName));
        } else {
            throw new IllegalArgumentException("Nieprawidłowy format pliku.");
        }
        System.out.println("Dane odczytane z pliku " + fileName);
    }

    public void backupMenu() {
        System.out.println("4. Kopia zapasowa");
        System.out.print(" [Z]achowaj/[O]dtwórz : ");
        String action = scanner.nextLine();
        try {
            if (action.equalsIgnoreCase("Z")) {
                System.out.print("Kompresja [G]zip/[Z]ip : ");
                String compression = scanner.nextLine();
                System.out.print("Nazwa pliku : ");
                String fileName = scanner.nextLine();
                saveToFile(fileName, compression);
            } else if (action.equalsIgnoreCase("O")) {
                System.out.print("Nazwa pliku : ");
                String fileName = scanner.nextLine();
                loadFromFile(fileName);
            } else {
                System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
            }
        } catch (IOException | ClassNotFoundException | IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}