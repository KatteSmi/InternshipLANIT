package enclosure;

import animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class AnimalEnclosure<T extends Animal> {

    private final Map<String, T> enclosureAnimals = new HashMap<>();

    public void addAnimal (T animal) {

        enclosureAnimals.put(animal.getName(), animal);

    }

    public void deleteAnimal (T animal) {

        enclosureAnimals.remove(animal.toString(),animal);

    }

    public T getALinkToAnimal(String name) {

        for (String key : enclosureAnimals.keySet()) {
            Animal value = enclosureAnimals.get(key);
            if (value.getName().equals(name)) {
                return (T) value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "AnimalEnclosure: " +
                "enclosureAnimals=" + enclosureAnimals +
                '}';
    }

    public Map<String, T> getEnclosureAnimals() {
        return enclosureAnimals;
    }


}
