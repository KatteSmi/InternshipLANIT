package animals.herbivores;

import animals.Herbivore;
import animals.animalBehavior.Fly;
import animals.animalBehavior.Swim;

public class Duck extends Herbivore implements Fly, Swim {

    public Duck(int countSatiety, int id, String name) {
        super(countSatiety, id, name);
    }

    public Duck(String name) {
        super(name);
    }

    public void fly() {
        System.out.println("Летим!");
    }

    public void swim() {
        System.out.println("Плывет утка!");
    }
}
