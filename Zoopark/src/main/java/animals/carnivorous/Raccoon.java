package animals.carnivorous;

import animals.Carnivorous;
import animals.animalBehavior.Swim;

public class Raccoon extends Carnivorous implements Swim {

    public Raccoon(int countSatiety, int id, String name) {
        super(countSatiety, id, name);
    }

    public Raccoon(String name) {
        super(name);
    }

    public void swim() {
        System.out.println("Плывет енот!");
    }
}
