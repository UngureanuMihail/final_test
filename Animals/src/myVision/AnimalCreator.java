package myVision;

public class AnimalCreator extends Creator {

    @Override
    protected Animal createNewPet(AnimalType type) {

        switch (type) {
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            case Hamster:
                return new Hamster();
        }
        return null;
    }
}