import animals.Animal;
import animals.animalBehavior.Swim;
import animals.animalBehavior.Voice;
import animals.carnivorous.Lion;
import animals.carnivorous.Raccoon;
import animals.herbivores.Duck;
import animals.herbivores.Fish;
import food.Food;
import food.typesOfFoodCarnivorous.Zebra;
import food.typesOfFoodHerbivores.Salat;
import food.typesOfFoodHerbivores.Seed;
import worker.Worker;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Lion lion = new Lion();
        Food zebra = new Zebra();
        Food salat = new Salat();

        worker.feed(lion, zebra);
        worker.feed(lion, salat);

        worker.getVoice(lion);

        List<Animal> pondWithAnimals = new ArrayList<Animal>();
        pondWithAnimals.add(new Fish());
        pondWithAnimals.add(new Duck());
        pondWithAnimals.add(new Raccoon());

        for (Animal animal : pondWithAnimals) {
            ((Swim) animal).swim();
        }

        Duck duck = new Duck();
        Food seed = new Seed();
        duck.eat(seed);
        System.out.printf("Животное съело: %s калорий\n", duck.getCountSatiety());

    }
}
