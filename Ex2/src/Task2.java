/*
3. *Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = new int[20];

        fillArray(arr);
        printArr(arr);
        sortArrAndLog(arr);
        printArr(arr);
    }

    static int[] fillArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 100);
        }
        return arr;
    }

    static int[] sortArrAndLog(int[] arr) {
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fh = null;
        try {
            fh = new FileHandler("logger.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.addHandler(fh);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    logger.info(Arrays.toString(arr));
                }
            }
        }
        fh.close();
        return arr;
    }

    static void printArr(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
