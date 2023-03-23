package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import myVision.*;
import DataBase.IRep;
import DataBase.AnimalRep;
import Interface.*;

public class AnimalController {
    private IRep<Animal> animalIRep;
    private Creator animalCreator;
    private final View<Animal> view;
    private Validator validator;

    public AnimalController(IRep<Animal> animalIRep) {
        this.animalIRep = animalIRep;
        this.animalCreator = new AnimalCreator();
        this.view = new ConsoleView();
        this.validator = new Validator();
    }

    public void createPet(AnimalType type) {

        String[] data = new String[] { view.getName(), view.getBirthday() };
        validator.validate(data);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(data[1], formatter);
        try {
            int res = animalIRep.create(animalCreator.createPet(type, data[0], birthday));
            view.showMessage(String.format("%d Данные сохранены", res));
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }

    }

    public void updatePet(int id) {

        Animal pet = getById(id);
        String[] data = new String[] { view.getName(), view.getBirthday() };

        validator.validate(data);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(data[1], formatter);
        pet.setName(data[0]);
        pet.setBirthday(birthday);
        try {
            int res = animalIRep.update(pet);
            view.showMessage(String.format("%d Данные сохранены \n", res));
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }

    }

    public void getAllPet() {
        try {
            view.printAll(animalIRep.getAll(), Animal.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public boolean trainPet(int id, String command) {
        try {

            if (((AnimalRep) animalIRep).getCommandsById(id, 1).contains(command))
                view.showMessage("Команда уже имеется");
            else {
                if (!((AnimalRep) animalIRep).getCommandsById(id, 2).contains(command))
                    view.showMessage("Команда невозможна");
                else {
                    ((AnimalRep) animalIRep).train(id, command);
                    view.showMessage("Команда добавлена\n");
                    return true;
                }
            }
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return false;
    }

    public Animal getById(int id) {
        try {
            return animalIRep.getById(id);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return null;
    }

    public void delete(int id) {
        try {
            animalIRep.delete(id);
            view.showMessage("Данные удалены");
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public void getCommands(int id) {
        try {
            view.printAll(((AnimalRep) animalIRep).getCommandsById(id, 1), String.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }
}