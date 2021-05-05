package animals.carnivorous;

import animals.Carnivorous;
import animals.animalBehavior.Voice;

public class Wolf extends Carnivorous implements Voice {

    public Wolf(int countFood) {
        super(countFood);
    }

    public Wolf() {
    }

    public String voice() {
        return "Голос волка";
    }
}

