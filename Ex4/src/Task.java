import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/*
1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
Постараться не обращаться к листу по индексам.
 */
public class Task {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> newList = new LinkedList<>();
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        System.out.println(list);

        while (listIterator.hasPrevious()) {
            newList.add(listIterator.previous());
        }

        System.out.println(newList);
    }
}