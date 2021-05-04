import model.Kotik;

public class Application {
    public static void main(String[] args) {

        Kotik kotik = new Kotik(5000, 50, "Vasya", "meow");
        Kotik cat = new Kotik();
        cat.setKotik(7000, 100, "Murka", "meow");

        kotik.liveAnotherDay();
        System.out.println("Имя кота: " + kotik.getName() + ". Вес кота: " + kotik.getWeight());

        if (kotik.getMeow().equals(cat.getMeow())) {
            System.out.println("Котики разговаривают одинаково");
        } else {
            System.out.println("Котики не разговаривают одинаково");
        }

        System.out.println("Количество котиков : " + Kotik.getInstanses());
    }
}

