import java.util.*;

/*
2. Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин,
Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова,
Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся
имена с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
 */
public class Task2 {
    public static void main(String[] args) {
        String text = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, " +
                "Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, " +
                "Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        List<String> list = editText(text);
        System.out.println(sortList(list));
    }

    static List<String> editText(String text) {
        text = text.replace(",", "");
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i += 2) {
            list.add(words[i]);
        }
        return list;
    }

    static Map<Integer, List<String>> sortList(List<String> list) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (String word : list) {
            if (hashMap.containsKey(word)) {
                int num = hashMap.get(word);
                num += 1;
                hashMap.put(word, num);
            } else {
                hashMap.put(word, 1);
            }
        }

        Map<Integer, List<String>> map = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            int num = entry.getValue();
            if (map.containsKey(num)) {
                List<String> list1 = map.get(num);
                list1.add(entry.getKey());
            } else {
                List<String> list1 = new ArrayList<>();
                list1.add(entry.getKey());
                map.put(num, list1);
            }
        }
            return map;
    }
}

