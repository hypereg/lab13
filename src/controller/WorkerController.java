package controller;

import model.Pracownik;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkerController {
    private List<Pracownik> employees = new ArrayList<>();

    public List<Pracownik> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Pracownik> employees) {
        this.employees = employees;
    }

    public void addEmployee(Pracownik employee) {
        employees.add(employee);
    }

    public boolean removeEmployee(String identifier) {
        Pracownik employeeToRemove = null;
        for (Pracownik pracownik : employees) {
            if (Objects.equals(pracownik.getIdentifier(), identifier)) {
                employeeToRemove = pracownik;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            return true;
        }
        return false;
    }
}