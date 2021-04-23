package animals.carnivorous;

import animals.Carnivorous;
import animals.TypesOfAviaries;
import animals.animalBehavior.Swim;

public class Raccoon extends Carnivorous implements Swim {

    public Raccoon(int countSatiety, int id, String name, TypesOfAviaries sizeEnclosure) {
        super(countSatiety, id, name, sizeEnclosure);
    }

    public Raccoon(String name, TypesOfAviaries sizeEnclosure) {
        super(name, sizeEnclosure);
        this.sizeEnclosure= sizeEnclosure;
    }

    public void swim() {
        System.out.println("Плывет енот!");
    }
}
