package animals.herbivores;

import animals.Herbivore;
import animals.TypesOfAviaries;
import animals.animalBehavior.Swim;

public class Fish extends Herbivore implements Swim {

    public Fish(int countSatiety, int id, String name, TypesOfAviaries sizeEnclosure) {
        super(countSatiety, id, name, sizeEnclosure);

    }

    public Fish(String name, TypesOfAviaries sizeEnclosure) {
        super(name, sizeEnclosure);
        this.sizeEnclosure= sizeEnclosure;
    }

    public void swim() {
        System.out.println("Плывет рыба!");
    }
}
