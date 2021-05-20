package animals.herbivores;

import animals.Herbivore;
import animals.TypesOfAviaries;
import animals.animalBehavior.Run;

public class Giraffe extends Herbivore implements Run {

    public Giraffe(int countSatiety, int id, String name, TypesOfAviaries sizeEnclosure) {
        super(countSatiety, id, name, sizeEnclosure);

    }

    public Giraffe(String name, TypesOfAviaries sizeEnclosure) {
        super(name, sizeEnclosure);
        this.sizeEnclosure= sizeEnclosure;
    }

    public void run() {
        System.out.println("Бежим!");
    }
}
