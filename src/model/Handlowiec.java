package model;

public class Handlowiec extends Pracownik {
    private long tax;
    private long taxLimit;

    public Handlowiec(String identifier, String name, String surname) {
        super(identifier, name, surname);
    }

    public Handlowiec(String identifier, String name, String surname, long salary, long salaryAddiction, String phoneNumber, String jobPhoneNumber, long tax, long taxLimit) {
        super(identifier, name, surname, salary, salaryAddiction, phoneNumber, jobPhoneNumber);
        this.tax = tax;
        this.taxLimit = taxLimit;
    }

    public long getTax() {
        return tax;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }

    public long getTaxLimit() {
        return taxLimit;
    }

    public void setTaxLimit(long taxLimit) {
        this.taxLimit = taxLimit;
    }
}
