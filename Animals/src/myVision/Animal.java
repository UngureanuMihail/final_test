package myVision;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Animal {

    protected int animalID;
    protected String name;
    protected LocalDate birthday;

    public void setPetId(int petId) {
        this.animalID = petId;
    }

    public int getPetId() {
        return animalID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void setBirthday(LocalDate date) {
        this.birthday = date;
    }

    public LocalDate getBirthdayDate(){
        return birthday;
    }

    public String getBirthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(birthday);
    }

    @Override
    public String toString() {
        return String.format("%d. %s: имя: %s, дата рождения: %s ", getPetId(), getClass().getSimpleName(), name, getBirthday());
    }
}