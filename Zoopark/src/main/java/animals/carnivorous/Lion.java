package animals.carnivorous;

import animals.Carnivorous;
import animals.animalBehavior.Voice;

public class Lion extends Carnivorous implements Voice {

    public Lion(int countSatiety, int id, String name) {
        super(countSatiety, id, name);
    }

    public Lion(String name) {
        super(name);
    }

    public String voice() {
        return "Голос льва";
    }

}
