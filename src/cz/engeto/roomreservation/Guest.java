package cz.engeto.roomreservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// [Domácí úkol - lekce 2]
public class Guest {
    private String name;
    private String surname;
    private LocalDate birthdate;

    // region Constructors
    public Guest(String name, String surname, LocalDate birthdate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }
    // endregion

    // region Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    // endregion

    public String getDescription () {
        DateTimeFormatter czechFormat = DateTimeFormatter.ofPattern("d.MM.yyyy");
        return name + " " + surname + " (" + birthdate.format(czechFormat) + ")";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
