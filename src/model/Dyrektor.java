package model;

import enums.JobLevel;

import java.io.Serializable;

public class Dyrektor extends Pracownik implements Serializable {
    private double costLimit;
    private double salaryAddiction;
    private final String cardNumber;

    public Dyrektor(String identifier, String name, String surname, JobLevel jobLevel, String cardNumber) {
        super(identifier, name, surname, jobLevel);
        this.cardNumber = cardNumber;
    }

    public Dyrektor(String identifier, String name, String surname, JobLevel jobLevel, double salary, String phoneNumber, double salaryAddiction, String jobPhoneNumber, double moneyLimit, String cardNumber) {
        super(identifier, name, surname, jobLevel, salary, phoneNumber, jobPhoneNumber);

        this.salaryAddiction = salaryAddiction;
        this.costLimit = moneyLimit;
        this.cardNumber = cardNumber;
    }

    public double getMoneyLimit() {
        return costLimit;
    }

    public void setMoneyLimit(double moneyLimit) {
        this.costLimit = moneyLimit;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public double getSalaryAddiction() {
        return salaryAddiction;
    }

    public void setSalaryAddiction(double salaryAddiction) {
        this.salaryAddiction = salaryAddiction;
    }
}
