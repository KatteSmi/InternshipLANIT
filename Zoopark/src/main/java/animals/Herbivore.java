package animals;

import food.Food;
import food.Grass;
import food.Meat;

public abstract class Herbivore extends Animal {

    public Herbivore(int countFood) {
        super(countFood);
    }

    public Herbivore() {
    }

    @Override
    public boolean eat(Food food) {
        if (!(food instanceof Grass)) {
            System.out.println("Эта еда не подходит!");
            return false;
        }
        System.out.println("Травоядный накормлен!");
        this.incSatiety(food);
        return true;
    }
}
