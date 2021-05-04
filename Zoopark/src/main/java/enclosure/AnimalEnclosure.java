package enclosure;

import animals.Animal;
import animals.TypesOfAviaries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AnimalEnclosure<T extends Animal> {

    private final Map<String, T> enclosureAnimals = new HashMap<>();
    TypesOfAviaries typesOfAviaries;

    public AnimalEnclosure(TypesOfAviaries typesOfAviaries) {
        this.typesOfAviaries = typesOfAviaries;
    }

    public void addAnimal(T animal) {

        if (checkingTheEnclosure(animal)) {
            enclosureAnimals.put(animal.getName(), animal);
        } else {
            System.out.println("Размер вольера не подходит!");
        }
    }

    public boolean checkingTheEnclosure(T animal) {

        switch (typesOfAviaries) {
            case SMALLAVIARY:
                switch (animal.getSizeEnclosure()) {
                    case MEDIUMAVIARY:
                    case LARGEAVIARY:
                    case VERYLARGEAVIARY:
                        return false;
                }
                return true;

            case MEDIUMAVIARY:
                switch (animal.getSizeEnclosure()) {
                    case LARGEAVIARY:
                    case VERYLARGEAVIARY:
                        return false;
                }
                return true;

            case LARGEAVIARY:
                switch (animal.getSizeEnclosure()) {
                    case VERYLARGEAVIARY:
                        return false;
                }
                return true;


            case VERYLARGEAVIARY:
                return true;

            default:
                throw new IllegalStateException("UnexpectedException" + typesOfAviaries);
        }
    }


    public void deleteAnimal(T animal) {

        enclosureAnimals.remove(animal.getName());

    }

    public T getALinkToAnimal(String name) {

        return (T) enclosureAnimals.get(name);
    }

    @Override
    public String toString() {
        return "AnimalEnclosure: " +
                "enclosureAnimals=" + enclosureAnimals +
                '}';
    }

    public Map<String, T> getEnclosureAnimals() {

        Set<Map.Entry<String, T>> entries = enclosureAnimals.entrySet();

        return (HashMap<String, T>) entries.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}



