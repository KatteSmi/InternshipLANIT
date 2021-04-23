package animals;

import food.Food;
import food.Meat;
import food.WrongFoodException;


public abstract class Carnivorous extends Animal{

    public Carnivorous(int countSatiety, int id, String name, TypesOfAviaries sizeEnclosure) {
        super(countSatiety, id, name, sizeEnclosure);
    }

    public Carnivorous(String name, TypesOfAviaries sizeEnclosure) {
        super(name, sizeEnclosure);
    }

    @Override
    public boolean eat(Food food) throws WrongFoodException {
        if (food instanceof Meat) {
            System.out.println("Хищник накормлен!");
            this.setSatiety(food);
            return true;
        } else {
            throw new WrongFoodException("Eда не подходит животному");
        }
    }
}


