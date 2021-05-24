import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService(new Scanner(System.in));
        calculatorService.getCalc();
    }
}