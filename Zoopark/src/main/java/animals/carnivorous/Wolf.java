package animals.carnivorous;

import animals.Carnivorous;
import animals.animalBehavior.Voice;

public class Wolf extends Carnivorous implements Voice {

    public Wolf(int countSatiety, int id, String name) {
        super(countSatiety, id, name);
    }

    public Wolf(String name) {
        super(name);
    }

    public String voice() {
        return "Голос волка";
    }
}

