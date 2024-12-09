package view;

import controller.WorkerController;
import enums.JobLevel;
import model.Dyrektor;
import model.Handlowiec;
import model.Pracownik;
import util.IdentifierUtil;

import java.util.List;
import java.util.Scanner;

public class WorkerView {
    private final Scanner scanner = new Scanner(System.in);
    private final WorkerController workerController;

    public WorkerView(WorkerController workerController) {
        this.workerController = workerController;
    }

    public void listEmployees() {
        List<Pracownik> employees = workerController.getEmployees();
        if (employees.isEmpty()) {
            System.out.println("Brak pracowników.");
            return;
        }

        for (int i = 0; i < employees.size(); i++) {
            Pracownik employee = employees.get(i);
            System.out.println("Identyfikator PESEL : " + employee.getIdentifier());
            System.out.println("Imię : " + employee.getName());
            System.out.println("Nazwisko : " + employee.getSurname());
            System.out.println("Stanowisko : " + employee.getJobLevel());
            System.out.println("Wynagrodzenie (zł) : " + employee.getSalary());
            System.out.println("Telefon służbowy numer : " + employee.getPhoneNumber());
            if (employee instanceof Dyrektor director) {
                System.out.println("Dodatek służbowy (zł) : " + director.getSalaryAddiction());
                System.out.println("Karta służbowa numer : " + director.getCardNumber());
                System.out.println("Limit kosztów/miesiąc (zł) : " + director.getMoneyLimit());
            } else if (employee instanceof Handlowiec handlowiec) {
                System.out.println("Prowizja (%) : " + handlowiec.getTax());
                System.out.println("Limit prowizji/miesiąc (zł) : " + handlowiec.getTaxLimit());
            }
            System.out.println("[Pozycja: " + (i + 1) + "/" + employees.size() + "]");
            System.out.println("[Enter] – następny");
            scanner.nextLine();
        }
    }

    public void addEmployee() {
        System.out.print("Typ pracownika ([D]yrektor/[H]andlowiec): ");
        String typeInput = scanner.nextLine();
        JobLevel type = typeInput.equalsIgnoreCase("D") ? JobLevel.DYREKTOR : JobLevel.HANDLOWIEC;

        String identifier;
        List<Pracownik> employees = workerController.getEmployees();
        do {
            System.out.print("Identyfikator PESEL : ");
            identifier = scanner.nextLine();
            if (!IdentifierUtil.isValidPesel(identifier)) {
                System.out.println("Nieprawidłowy PESEL. Spróbuj ponownie.");
            } else if (!IdentifierUtil.isUniquePesel(identifier, employees)) {
                System.out.println("PESEL już istnieje. Spróbuj ponownie.");
            }
        } while (!IdentifierUtil.isValidPesel(identifier) || !IdentifierUtil.isUniquePesel(identifier, employees));

        System.out.print("Imię : ");
        String name = scanner.nextLine();
        System.out.print("Nazwisko : ");
        String surname = scanner.nextLine();
        System.out.print("Telefon number prywatny : ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Wynagrodzenie (zł) : ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Telefon służbowy numer : ");
        String jobPhoneNumber = scanner.nextLine();

        if (type == JobLevel.DYREKTOR) {
            System.out.print("Dodatek służbowy (zł) : ");
            double salaryAddiction = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Karta służbowa numer : ");
            String cardNumber = scanner.nextLine();
            System.out.print("Limit kosztów/miesiąc (zł) : ");
            double costLimit = scanner.nextDouble();
            scanner.nextLine();
            workerController.addEmployee(new Dyrektor(identifier, name, surname, type, salary, phoneNumber, salaryAddiction, jobPhoneNumber, costLimit, cardNumber));
        } else {
            System.out.print("Prowizja (%) : ");
            double tax = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Limit prowizji/miesiąc (zł) : ");
            double taxLimit = scanner.nextDouble();
            scanner.nextLine();
            workerController.addEmployee(new Handlowiec(identifier, name, surname, type, salary, phoneNumber, jobPhoneNumber, tax, taxLimit));
        }
    }

    public void removeEmployee() {
        System.out.print("Podaj Identyfikator PESEL: ");
        String identifier = scanner.nextLine();
        if (workerController.removeEmployee(identifier)) {
            System.out.println("Pracownik usunięty.");
        } else {
            System.out.println("Pracownik o podanym PESEL nie istnieje.");
        }
    }
}