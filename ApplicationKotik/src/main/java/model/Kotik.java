package model;

public class Kotik {
    //вес кошки
    private int weight;
    //степень сытости кошки
    private int degreeOfSatiety;
    private String name;
    private String meow;
    private static int instanses = 0;

    public static int getInstanses() {
        return instanses;
    }

    public double getWeight() {
        return weight;
    }

    public int getDegreeOfSatiety() {
        return degreeOfSatiety;
    }

    public String getName() {
        return name;
    }

    public String getMeow() {
        return meow;
    }

    public Kotik (int weight, int degreeOfSatiety, String name, String meow) {
        this.weight = weight;
        this.degreeOfSatiety = degreeOfSatiety;
        this.name = name;
        this.meow = meow;
        instanses++;
    }

    public Kotik() {
        instanses++;
    }

    public void setKotik (int weight, int degreeOfSatiety, String name, String meow) {
        this.name = name;
        this.weight = weight;
        this.degreeOfSatiety = degreeOfSatiety;
        this.meow = meow;
    }

    public boolean play() {
        weight = weight - 300;
        System.out.println("Кот поиграл");
        return true;
    }

    public boolean meow() {
        weight = weight - 100;
        System.out.println("Кот говорит Meow");
        return true;
    }

    public boolean pee() {
        weight = weight - 200;
        System.out.println("Кот сходил в туалет");
        return true;
    }

    public boolean sleep() {
        weight = weight + 200;
        System.out.println("Кот спит");
        return true;
    }

    public boolean chaseMouse () {
        weight = weight - 500;
        System.out.println("Кот спит");
        return true;
    }

    public void eat (int amount) {
        weight = weight + amount;
        System.out.println("Кошка поела и весит: " + weight);
    }

    public void eat(int amount, String foodName) {
        weight = weight + amount;
        System.out.println("Кот поел :" + foodName + " и весит: " + weight);
    }

    public void eat() {
        int amount = 0;
        String foodName = null;
        eat(amount, foodName);
    }

    public boolean repleteCat() {
        if (getDegreeOfSatiety() > 0) {
            return true;
        } else if (getDegreeOfSatiety() <= 0) {
            System.out.println("Кот голоден, нужно его покормить!");
            eat(250," Мокрый корм");
        }
        return false;
    }

    public void liveAnotherDay() {
        for (int i = 1; i <= 24; i++) {
            if (repleteCat()) {
                int value = 5;
                int randomNumber = (int) (Math.random() * value + 1);
                switch (randomNumber) {
                    case 1:
                        play();
                        break;
                    case 2:
                        meow();
                        break;
                    case 3:
                        pee();
                        break;
                    case 4:
                        sleep();
                        break;
                    case 5:
                        chaseMouse();
                        break;
                }
            }
        }
    }
}




