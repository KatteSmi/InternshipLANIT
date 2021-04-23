package animals.carnivorous;

import animals.Carnivorous;
import animals.TypesOfAviaries;
import animals.animalBehavior.Voice;

public class Lion extends Carnivorous implements Voice {

    public Lion(int countSatiety, int id, String name, TypesOfAviaries sizeEnclosure) {
        super(countSatiety, id, name, sizeEnclosure);

    }

    public Lion(String name, TypesOfAviaries sizeEnclosure) {
        super(name, sizeEnclosure);
        this.sizeEnclosure = sizeEnclosure;
    }

    public String voice() {
        return "Голос льва";
    }

}
