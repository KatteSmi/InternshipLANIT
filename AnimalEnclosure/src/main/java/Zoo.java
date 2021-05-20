import animals.Animal;
import animals.TypesOfAviaries;
import animals.carnivorous.Wolf;
import animals.herbivores.Duck;
import enclosure.AnimalEnclosure;
import animals.Carnivorous;
import animals.Herbivore;
import animals.carnivorous.Lion;
import food.Food;
import food.WrongFoodException;
import food.typesOfFoodCarnivorous.Zebra;
import food.typesOfFoodHerbivores.Salat;
import worker.Worker;

import java.util.Map;

public class Zoo {

    public static void main(String[] args) {

        Zebra zebra = new Zebra();
        Salat salat = new Salat();

        Worker worker = new Worker();

        Lion lion = new Lion("Лев", TypesOfAviaries.LARGEAVIARY);
        Lion leo = new Lion("Маленький лев", TypesOfAviaries.MEDIUMAVIARY);
        Wolf wolf = new Wolf("Волк", TypesOfAviaries.VERYLARGEAVIARY);

        Duck duck = new Duck("Утка", TypesOfAviaries.MEDIUMAVIARY);

        worker.feed(lion, salat);
        worker.feed(duck, zebra);


        try {
            lion.eat(salat);
        } catch (WrongFoodException exception) {
            exception.printStackTrace();
        }


        AnimalEnclosure<Carnivorous> animalEnclosureCarnivorous = new AnimalEnclosure<>(TypesOfAviaries.LARGEAVIARY);
        AnimalEnclosure<Herbivore> animalEnclosureHerbivore = new AnimalEnclosure<>(TypesOfAviaries.MEDIUMAVIARY);

        animalEnclosureCarnivorous.addAnimal(lion);
        animalEnclosureCarnivorous.addAnimal(leo);
        animalEnclosureCarnivorous.addAnimal(wolf);
        System.out.println(animalEnclosureCarnivorous);

        animalEnclosureHerbivore.addAnimal(duck);
        System.out.println(animalEnclosureHerbivore);


        Map<String, Carnivorous> copy = animalEnclosureCarnivorous.getEnclosureAnimals();


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
