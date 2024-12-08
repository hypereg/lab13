package controller;

import model.Dyrektor;
import model.Handlowiec;
import model.Pracownik;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class WorkerController {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Pracownik> employees = new ArrayList<>();

    public WorkerController() {

    }
    private void listEmployees() {
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

    private void addEmployee() {
        System.out.print("[D]yrektor/[H]handlowiec: ");
        String type = scanner.nextLine();
        System.out.print("Identyfikator PESEL : ");
        String identifier = scanner.nextLine();
        System.out.print("Imię : ");
        String name = scanner.nextLine();
        System.out.print("Nazwisko : ");
        String surname = scanner.nextLine();
        System.out.println("Stanowisko : ");
        System.out.print("Telefon number prywatny : ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Wynagrodzenie (zł) : ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Telefon służbowy numer : ");
        String jobPhoneNumber = scanner.nextLine();

        if (type.equalsIgnoreCase("D")) {
            System.out.print("Dodatek służbowy (zł) : ");
            double salaryAddiction = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Karta służbowa numer : ");
            String cardNumber = scanner.nextLine();
            System.out.print("Limit kosztów/miesiąc (zł) : ");
            double costLimit = scanner.nextDouble();
            scanner.nextLine();
            employees.add(new Dyrektor(identifier, name, surname, jobLevel, salary, phoneNumber, salaryAddiction, jobPhoneNumber, costLimit, cardNumber));
        } else if (type.equalsIgnoreCase("H")) {
            System.out.print("Prowizja (%) : ");
            double tax = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Limit prowizji/miesiąc (zł) : ");
            double taxLimit = scanner.nextDouble();
            scanner.nextLine();
            // employees.add(new Handlowiec(identifier, name, surname, salary, phoneNumber, commission, commissionLimit));
        } else {
            System.out.println("Nieprawidłowy typ pracownika.");
        }
    }

    private void removeEmployee() {
        System.out.print("Podaj Identyfikator PESEL: ");
        String identifier = scanner.nextLine();
        Pracownik employeeToRemove = null;
        for (Pracownik pracownik : employees) {
            if (Objects.equals(pracownik.getIdentifier(), identifier)) {
                employeeToRemove = pracownik;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Pracownik usunięty.");
        } else {
            System.out.println("Pracownik o podanym PESEL nie istnieje.");
        }
    }
}
