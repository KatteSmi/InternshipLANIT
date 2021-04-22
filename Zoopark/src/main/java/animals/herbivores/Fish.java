package animals.herbivores;

import animals.Herbivore;
import animals.animalBehavior.Swim;

public class Fish extends Herbivore implements Swim {

    public Fish(int countSatiety, int id, String name) {
        super(countSatiety, id, name);
    }

    public Fish(String name) {
        super(name);
    }

    public void swim() {
        System.out.println("Плывет рыба!");
    }
}
