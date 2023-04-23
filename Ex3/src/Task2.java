import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
Collections.max()
 */
public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = createList(20, 1, 30);
        System.out.println(list);
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
        average(list);

    }
    static List<Integer> createList(int size, int min, int max) {
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }
    static void average(List<Integer> list) {
        double sum = 0;
        for (int num: list) {
            sum += num;
        }
        System.out.println(sum / list.size());
    }
}
