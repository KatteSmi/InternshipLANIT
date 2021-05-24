package worker;

import animals.Animal;
import animals.animalBehavior.Voice;
import food.Food;
import food.WrongFoodException;

public class Worker {

    public void feed(Animal animal, Food food) {
        try {
            animal.eat(food);
        } catch (WrongFoodException exception) {
            exception.printStackTrace();
        }
    }

    public void getVoice (Voice animal) {
        System.out.println(animal.voice());

    }


}
