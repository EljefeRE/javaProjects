// 2. Вычислить n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Factorial();
    }

    static void Factorial() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = sc.nextInt();
        int fac = 1;
        for (int i = 1; i < num + 1; i++) {
            fac *= i;
        }
        System.out.println(fac);
    }
}
