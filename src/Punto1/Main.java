package Punto1;

public class Main {
    public static void main(String[] args) {
        DPFactorial factorial = new DPFactorial();

        for (int i = 1; i < 10; i++) {
            System.out.println(factorial.factorial(i));
        }

    }
}
