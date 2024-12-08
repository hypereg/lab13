package model;

import enums.JobLevel;

public class Dyrektor extends Pracownik {
    private double costLimit;
    private final String cardNumber;

    public Dyrektor(String identifier, String name, String surname, JobLevel jobLevel, String cardNumber) {
        super(identifier, name, surname, jobLevel);
        this.cardNumber = cardNumber;
    }

    public Dyrektor(String identifier, String name, String surname, JobLevel jobLevel, double salary, String phoneNumber, double salaryAddiction, String jobPhoneNumber, double moneyLimit, String cardNumber) {
        super(identifier, name, surname, jobLevel, salary, salaryAddiction, phoneNumber, jobPhoneNumber);
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
}
