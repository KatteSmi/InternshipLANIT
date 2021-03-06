package model;

public class Kotik {
    //вес кошки
    private int weight;
    //степень сытости кошки
    private int degreeOfSatiety;
    private String name;
    private String meow;
    private static int instanses = 0;

    public Kotik(int weight, int degreeOfSatiety, String name, String meow) {
        this.weight = weight;
        this.degreeOfSatiety = degreeOfSatiety;
        this.name = name;
        this.meow = meow;
        instanses++;
    }

    public Kotik() {
        instanses++;
    }

    public void setKotik(int weight, int degreeOfSatiety, String name, String meow) {
        this.name = name;
        this.weight = weight;
        this.degreeOfSatiety = degreeOfSatiety;
        this.meow = meow;
    }

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

    public boolean play() {
        weight = weight - 300;
        degreeOfSatiety = degreeOfSatiety - 2;
        if (degreeOfSatiety >= 0) {
            System.out.println(name + " поиграл. Степень сытости: " + degreeOfSatiety);
            return true;
        } else {
            System.out.println("Покормите кота!");
        }
        return false;
    }

    public boolean meow() {
        weight = weight - 100;
        degreeOfSatiety = degreeOfSatiety - 1;
        if (degreeOfSatiety >= 0) {
            System.out.println("Кот говорит Meow. Степень сытости: " + degreeOfSatiety);
            return true;
        } else {
            System.out.println("Покормите кота!");
        }
        return false;
    }

    public boolean pee() {
        weight = weight - 200;
        degreeOfSatiety = degreeOfSatiety - 2;
        if (degreeOfSatiety >= 0) {
            System.out.println("Кот сходил в туалет. Степень сытости: " + degreeOfSatiety);
            return true;
        } else {
            System.out.println("Покормите кота!");
        }
        return false;
    }

    public boolean sleep() {
        weight = weight + 200;
        degreeOfSatiety = degreeOfSatiety + 2;
        if (degreeOfSatiety >= 0) {
            System.out.println("Кот спит. Степень сытости: " + degreeOfSatiety);
            return true;
        } else {
            System.out.println("Покормите кота!");
        }
        return false;
    }

    public boolean chaseMouse() {
        weight = weight - 500;
        degreeOfSatiety = degreeOfSatiety - 5;
        if (degreeOfSatiety >= 0) {
            System.out.println(name + " ловит мышей. Степень сытости: " + degreeOfSatiety);
            return true;
        } else {
            System.out.println("Покормите кота!");
        }
        return false;
    }

    public void eat(int amount) {
        weight = weight + amount;
        System.out.println("Кошка поела и весит: " + weight);
    }

    public void eat(int amount, String foodName) {
        weight = weight + amount;
        degreeOfSatiety = degreeOfSatiety + 20;
        System.out.println("Кот поел :" + foodName + ". Вес: " + weight + ". Степень сытости: " + degreeOfSatiety);
    }

    public void eat() {
        int amount = 0;
        String foodName = null;
        eat(amount, foodName);
    }

    public void liveAnotherDay() {
        for (int i = 1; i <= 24; i++) {
                int value = 5;
                int randomNumber = (int) (Math.random() * value + 1);
                System.out.print(i + ". ");
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





