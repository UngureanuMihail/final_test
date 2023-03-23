package myVision;

import java.time.LocalDate;

public abstract class Creator {

    protected abstract Animal createNewPet(AnimalType type);

    public Animal createPet(AnimalType type, String name, LocalDate date) {

        Animal pet = createNewPet(type);
        pet.setName(name);
        Animal.setBirthday(date);
        return pet;
    }
}