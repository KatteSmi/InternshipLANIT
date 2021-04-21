package animals;

import food.Food;

public abstract class Animal {

    private int countSatiety = 0;


    public Animal(int countSatiety) {
        this.countSatiety = countSatiety;
    }

    public Animal () {
    }

    public abstract boolean eat(Food food);

    protected void setSatiety(Food food) {
        countSatiety += food.getCallories();
    }

    public int getCountSatiety() {
        return countSatiety;
    }
}
