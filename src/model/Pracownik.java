package model;

import enums.JobLevel;

import java.io.Serializable;

public abstract class Pracownik extends Osoba implements Serializable {
    private JobLevel jobLevel;
    private double salary;
    private String phoneNumber;
    private String jobPhoneNumber;

    public Pracownik(String identifier, String name, String surname, JobLevel jobLevel) {
        super(identifier, name, surname, jobLevel);
    }

    public Pracownik(String identifier, String name, String surname, JobLevel jobLevel, double salary, String phoneNumber, String jobPhoneNumber) {
        super(identifier, name, surname, jobLevel);
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.jobPhoneNumber = jobPhoneNumber;
        this.jobLevel = jobLevel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
