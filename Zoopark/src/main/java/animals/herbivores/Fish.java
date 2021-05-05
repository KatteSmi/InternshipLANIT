package animals.herbivores;

import animals.Herbivore;
import animals.animalBehavior.Swim;

public class Fish extends Herbivore implements Swim {

    public Fish(int countFood) {
        super(countFood);
    }

    public Fish() {
    }

    public void swim() {
        System.out.println("Плывет рыба!");
    }
}
