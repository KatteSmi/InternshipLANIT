package animals;

import food.Food;
import food.Grass;
import food.Meat;
import food.WrongFoodException;

public abstract class Herbivore extends Animal {

    public Herbivore(int countSatiety, int id, String name, TypesOfAviaries sizeEnclosure) {
        super(countSatiety, id, name, sizeEnclosure);
    }

    public Herbivore(String name, TypesOfAviaries sizeEnclosure) {
        super(name, sizeEnclosure);
    }

    @Override
    public boolean eat(Food food) {
        try {
            if (!(food instanceof Grass))
                throw new WrongFoodException("Eда не подходит животному");
            else {
                System.out.println("Травоядный накормлен!");
                this.setSatiety(food);
                return true;
            }
        } catch (WrongFoodException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}

