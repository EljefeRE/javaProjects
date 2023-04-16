// 4. Реализовать простой калькулятор (введите первое число, введите второе число, введите требуемую операцию, ответ)

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Calculator();
    }

    static void Calculator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите перое число: ");
        int num1 = sc.nextInt();
        System.out.println("Введите второе число: ");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите операцию: ");
        char op = sc.nextLine().charAt(0);

        if (op == '+'){
            System.out.println(num1 + num2);
        } else if (op == '-') {
            System.out.println(num1 - num2);
        } else if (op == '/') {
            if(num2 != 0){
                System.out.println((double) num1 / num2);
            }else {
                System.out.println("На ноль делить нельзя");
            }
        } else if (op == '*') {
            System.out.println(num1 * num2);
        }else {
            System.out.println("Не известная операция");
        }
    }




}
