package animals.herbivores;

import animals.Herbivore;
import animals.animalBehavior.Run;

public class Giraffe extends Herbivore implements Run {

    public Giraffe(int countSatiety, int id, String name) {
        super(countSatiety, id, name);
    }

    public Giraffe(String name) {
        super(name);
    }

    public void run() {
        System.out.println("Бежим!");
    }
}
