package animals;

import food.Food;
import food.Meat;


public abstract class Carnivorous extends Animal{

    public Carnivorous(int countSatiety, int id, String name) {
        super(countSatiety, id, name);
    }

    public Carnivorous(String name) {
        super(name);
    }

    @Override
    public boolean eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Хищник накормлен!");
            this.setSatiety(food);
            return true;
        } else {
            System.out.println("Эта еда не подходит!");
        }
        return false;
    }
}


