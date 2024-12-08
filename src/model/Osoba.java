package model;

public abstract class Osoba {
    private final String identifier;
    private final String name;
    private final String surname;

    public Osoba(String identifier, String name, String surname) {
        this.identifier = identifier;
        this.name = name;
        this.surname = surname;
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
}
