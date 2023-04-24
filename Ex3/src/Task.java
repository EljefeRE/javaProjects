/*
Пусть дан произвольный список целых чисел, удалить из него четные числа
*Реализовать алгоритм сортировки слиянием
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task {
    public static void main(String[] args) {
        List<Integer> list = createList(20, 2, 20);
        System.out.println(list);
        delEvenNum(list);
        System.out.println(list);
    }
    static List<Integer> createList(int size, int min, int max) {
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }
    static void delEvenNum(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
    }
}