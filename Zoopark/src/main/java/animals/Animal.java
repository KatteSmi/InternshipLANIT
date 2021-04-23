package animals;

import food.Food;
import food.WrongFoodException;

import java.util.Objects;

public abstract class Animal {

    private int countSatiety = 0;
    private int id;
    private String name;
    protected TypesOfAviaries sizeEnclosure;

    public TypesOfAviaries getSizeEnclosure() {
        return sizeEnclosure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return name;
    }


    public String getName() {
        return name;
    }


    public Animal(int countSatiety, int id, String name, TypesOfAviaries sizeEnclosure) {
        this.countSatiety = countSatiety;
        this.id = id;
        this.name = name;
        this.sizeEnclosure = sizeEnclosure;
    }

    public Animal (String name, TypesOfAviaries sizeEnclosure) {
        this.name = name;
        this.sizeEnclosure = sizeEnclosure;
    }

    public abstract boolean eat(Food food) throws WrongFoodException;

    protected void setSatiety(Food food) {
        countSatiety += food.getCallories();
    }

}
