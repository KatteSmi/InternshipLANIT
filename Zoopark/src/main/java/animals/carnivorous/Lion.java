package animals.carnivorous;

import animals.Carnivorous;
import animals.animalBehavior.Voice;

public class Lion extends Carnivorous implements Voice {

    public Lion(int countFood) {
        super(countFood);
    }

    public Lion() {
    }

    public String voice() {
        return "Голос льва";
    }
}
