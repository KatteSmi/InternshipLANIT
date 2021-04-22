import animals.herbivores.Duck;
import enclosure.AnimalEnclosure;
import animals.Carnivorous;
import animals.Herbivore;
import animals.carnivorous.Lion;

public class Zoo {
    public static void main(String[] args) {

        Lion lion = new Lion("Лев");
        Duck duck = new Duck("Утка");



       AnimalEnclosure<Carnivorous> animalEnclosureCarnivorous = new AnimalEnclosure<>();
        AnimalEnclosure<Herbivore> animalEnclosureHerbivore = new AnimalEnclosure<>();

//       animalEnclosureCarnivorous.addAnimal(lion);
//
//        System.out.println(animalEnclosureCarnivorous);
//
//        animalEnclosureHerbivore.addAnimal(duck);
//
//        animalEnclosureHerbivore.getALinkToAnimal("Утка");
//
//        System.out.println(animalEnclosureHerbivore);


    }
}
