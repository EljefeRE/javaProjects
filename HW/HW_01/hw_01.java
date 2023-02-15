package HW.HW_01;

import java.util.Scanner;

public class hw_01 {

    public static void main(String[] args) {
            
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = sc.nextInt();
        System.out.println(triangle(num));

    }

    static int triangle(int num) {
            return num = num * (num + 1) / 2;
    }
}