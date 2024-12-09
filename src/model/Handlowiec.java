package model;

import enums.JobLevel;

import java.io.Serializable;

public class Handlowiec extends Pracownik implements Serializable {
    private double tax;
    private double taxLimit;

    public Handlowiec(String identifier, String name, String surname, JobLevel jobLevel) {
        super(identifier, name, surname, jobLevel);
    }

    public Handlowiec(String identifier, String name, String surname, JobLevel jobLevel, double salary, String phoneNumber, String jobPhoneNumber, double tax, double taxLimit) {
        super(identifier, name, surname, jobLevel, salary, phoneNumber, jobPhoneNumber);
        this.tax = tax;
        this.taxLimit = taxLimit;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTaxLimit() {
        return taxLimit;
    }

    public void setTaxLimit(long taxLimit) {
        this.taxLimit = taxLimit;
    }
}
