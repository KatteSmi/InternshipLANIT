package animals;

import food.Food;

import java.util.Objects;

public abstract class Animal {

    private int countSatiety = 0;
    private int id;
    private String name;

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

    public void setCountSatiety(int countSatiety) {
        this.countSatiety = countSatiety;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(int countSatiety, int id, String name) {
        this.countSatiety = countSatiety;
        this.id = id;
        this.name = name;
    }

    public Animal (String name) {
        this.name = name;
    }

    public abstract boolean eat(Food food);

    protected void setSatiety(Food food) {
        countSatiety += food.getCallories();
    }

    public int getCountSatiety() {
        return countSatiety;
    }
}
