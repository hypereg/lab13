package model;

import enums.JobLevel;

import java.io.Serializable;

public abstract class Osoba implements Serializable {
    private final String identifier;
    private final String name;
    private final String surname;
    private final JobLevel jobLevel;

    public Osoba(String identifier, String name, String surname, JobLevel jobLevel) {
        this.identifier = identifier;
        this.name = name;
        this.surname = surname;
        this.jobLevel = jobLevel;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public JobLevel getJobLevel() {
        return jobLevel;
    }
}
