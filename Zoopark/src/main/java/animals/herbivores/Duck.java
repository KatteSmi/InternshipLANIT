package animals.herbivores;

import animals.Herbivore;
import animals.TypesOfAviaries;
import animals.animalBehavior.Fly;
import animals.animalBehavior.Swim;

public class Duck extends Herbivore implements Fly, Swim {

    public Duck(int countSatiety, int id, String name, TypesOfAviaries sizeEnclosure) {
        super(countSatiety, id, name, sizeEnclosure);

    }

    public Duck(String name, TypesOfAviaries sizeEnclosure) {
        super(name, sizeEnclosure);
        this.sizeEnclosure= sizeEnclosure;
    }

    public void fly() {
        System.out.println("Летим!");
    }

    public void swim() {
        System.out.println("Плывет утка!");
    }
}
