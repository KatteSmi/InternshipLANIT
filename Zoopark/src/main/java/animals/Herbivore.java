package animals;

import food.Food;
import food.Grass;
import food.Meat;

public abstract class Herbivore extends Animal {

    public Herbivore(int countSatiety, int id, String name) {
        super(countSatiety, id, name);
    }

    public Herbivore(String name) {
        super(name);
    }

    @Override
    public boolean eat(Food food) {
        if (food instanceof Grass) {
            System.out.println("Травоядный накормлен!");
            this.setSatiety(food);
            return true;
        } else {
            System.out.println("Эта еда не подходит!");
        }
        return false;
    }
}
