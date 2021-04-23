import animals.TypesOfAviaries;
import animals.carnivorous.Wolf;
import animals.herbivores.Duck;
import enclosure.AnimalEnclosure;
import animals.Carnivorous;
import animals.Herbivore;
import animals.carnivorous.Lion;

public class Zoo {
    public static void main(String[] args) {

        Lion lion = new Lion("Лев", TypesOfAviaries.LARGEAVIARY);
        Duck duck = new Duck("Утка", TypesOfAviaries.MEDIUMAVIARY);
        Wolf wolf = new Wolf("Волк", TypesOfAviaries.LARGEAVIARY);


        AnimalEnclosure<Carnivorous> animalEnclosureCarnivorous = new AnimalEnclosure<>(TypesOfAviaries.LARGEAVIARY);
        AnimalEnclosure<Herbivore> animalEnclosureHerbivore = new AnimalEnclosure<>(TypesOfAviaries.MEDIUMAVIARY);

        animalEnclosureCarnivorous.addAnimal(lion);
        animalEnclosureCarnivorous.addAnimal(wolf);

        System.out.println(animalEnclosureCarnivorous);

        animalEnclosureHerbivore.addAnimal(duck);

        animalEnclosureHerbivore.getALinkToAnimal("Утка");

        System.out.println(animalEnclosureHerbivore);




    }
}
