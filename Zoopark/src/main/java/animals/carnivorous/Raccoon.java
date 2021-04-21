package animals.carnivorous;

import animals.Carnivorous;
import animals.animalBehavior.Swim;

public class Raccoon extends Carnivorous implements Swim {

    public Raccoon(int countFood) {
        super(countFood);
    }

    public Raccoon() {
    }

    public void swim() {
        System.out.println("Плывет енот!");
    }
}
