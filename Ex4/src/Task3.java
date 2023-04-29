
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

/*
3. Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
 */
public class Task3 {
    public static void main(String[] args) {
        LinkedList<Integer> list = createAndFill();
        System.out.println(list);
        sumList(list);
    }
    static LinkedList<Integer> createAndFill() {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1, 10));
        }
        return list;
    }

    static void sumList(LinkedList<Integer> list) {
        ListIterator<Integer> iterator = list.listIterator(list.size());
        int sum = 0;
        while (iterator.hasPrevious()) {
            sum += iterator.previous();
        }
        System.out.println("Cумма элементов листа = " + sum);
    }
}
