package animals.herbivores;

import animals.Herbivore;
import animals.animalBehavior.Run;

public class Giraffe extends Herbivore implements Run {

    public Giraffe(int countFood) {
        super(countFood);
    }

    public Giraffe() {
    }

    public void run() {
        System.out.println("Бежим!");
    }
}
