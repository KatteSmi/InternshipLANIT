package animals;

import food.Food;
import food.Meat;


public abstract class Carnivorous extends Animal {

    public Carnivorous(int countFood) {
        super(countFood);
    }

    public Carnivorous() {

    }

    @Override
    public boolean eat(Food food) {
        if (!(food instanceof Meat)) {
            System.out.println("Эта еда не подходит!");
            return false;
        }
        System.out.println("Хищник накормлен!");
        this.incSatiety(food);
        return true;
    }
}


