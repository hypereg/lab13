package model;

import enums.JobLevel;

public abstract class Pracownik extends Osoba {
    private JobLevel jobLevel;
    private double salary;
    private double salaryAddiction;
    private String phoneNumber;
    private String jobPhoneNumber;

    // Konstruktor wymagany
    public Pracownik(String identifier, String name, String surname, JobLevel jobLevel) {
        super(identifier, name, surname);
    }

    // Konstruktor opcjonalny
    public Pracownik(String identifier, String name, String surname, JobLevel jobLevel, double salary, double salaryAddiction, String phoneNumber, String jobPhoneNumber) {
        super(identifier, name, surname);
        this.salary = salary;
        this.salaryAddiction = salaryAddiction;
        this.phoneNumber = phoneNumber;
        this.jobPhoneNumber = jobPhoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalaryAddiction() {
        return salaryAddiction;
    }

    public void setSalaryAddiction(double salaryAddiction) {
        this.salaryAddiction = salaryAddiction;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobPhoneNumber() {
        return jobPhoneNumber;
    }

    public void setJobPhoneNumber(String jobPhoneNumber) {
        this.jobPhoneNumber = jobPhoneNumber;
    }
    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(JobLevel jobLevel) {
        this.jobLevel = jobLevel;
    }
}
