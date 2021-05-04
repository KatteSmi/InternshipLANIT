import animals.Animal;
import animals.TypesOfAviaries;
import animals.carnivorous.Wolf;
import animals.herbivores.Duck;
import enclosure.AnimalEnclosure;
import animals.Carnivorous;
import animals.Herbivore;
import animals.carnivorous.Lion;

import java.util.Map;

public class Zoo {
    public static void main(String[] args) {

        Lion lion = new Lion("Лев", TypesOfAviaries.LARGEAVIARY);
        Lion leo = new Lion("Маленький лев", TypesOfAviaries.SMALLAVIARY);

        Duck duck = new Duck("Утка", TypesOfAviaries.MEDIUMAVIARY);
        Wolf wolf = new Wolf("Волк", TypesOfAviaries.LARGEAVIARY);


        AnimalEnclosure<Carnivorous> animalEnclosureCarnivorous = new AnimalEnclosure<>(TypesOfAviaries.LARGEAVIARY);
        AnimalEnclosure<Herbivore> animalEnclosureHerbivore = new AnimalEnclosure<>(TypesOfAviaries.MEDIUMAVIARY);

        animalEnclosureCarnivorous.addAnimal(lion);
        animalEnclosureCarnivorous.addAnimal(leo);
        animalEnclosureCarnivorous.addAnimal(wolf);

      Map<String, Carnivorous> copy=  animalEnclosureCarnivorous.getEnclosureAnimals();
        System.out.println(animalEnclosureCarnivorous);

        animalEnclosureCarnivorous.deleteAnimal(lion);
        System.out.println(copy + " -Копия");

        animalEnclosureCarnivorous.getEnclosureAnimals();
        System.out.println(animalEnclosureCarnivorous);


        animalEnclosureHerbivore.addAnimal(duck);

        Animal findDuck = animalEnclosureHerbivore.getALinkToAnimal("Утка");
        System.out.println(findDuck);

        System.out.println(animalEnclosureHerbivore);




    }
}
