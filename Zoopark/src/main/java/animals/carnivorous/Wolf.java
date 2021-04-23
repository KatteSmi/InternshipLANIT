package animals.carnivorous;

import animals.Carnivorous;
import animals.TypesOfAviaries;
import animals.animalBehavior.Voice;

public class Wolf extends Carnivorous implements Voice {

    public Wolf(int countSatiety, int id, String name, TypesOfAviaries sizeEnclosure) {
        super(countSatiety, id, name, sizeEnclosure);

    }

    public Wolf(String name, TypesOfAviaries sizeEnclosure) {
        super(name, sizeEnclosure);
        this.sizeEnclosure= sizeEnclosure;
    }

    public String voice() {
        return "Голос волка";
    }
}

