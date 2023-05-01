import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */
public class PhoneBook {
    private Map<String, List<String>> map = new HashMap<>();

    void add(String name, String number) {
        if (map.containsKey(name)) {
            List<String> list = map.get(name);
            list.add(number);
        } else {
            List<String> list = new ArrayList<>();
            list.add(number);
            map.put(name, list);
        }
    }

    String getByName(String name) {
        return name + ": " + map.get(name);
    }

    String getByNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(number)) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append("\n");
            }
        }
        if (sb.isEmpty()) {
            System.out.println("Записей нет");
        }
        return sb.toString();
    }

    String getAllList() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }
}

