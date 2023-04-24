import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
Вывести название каждой планеты и количество его повторений в списке.
 */
public class Task3 {
    public static void main(String[] args) {
        String[] planets = new String[] {"Меркурий", "Венера", "Земля", "Марс", "Юпитер",
                                        "Сатурн", "Уран", "Нептун", "Плутон"};
        List<String> solarSystem = new ArrayList<>();
        System.out.println(createList(solarSystem, planets));
        countPlanets(planets, solarSystem);

    }
    static List<String> createList(List<String> list, String[] arr) {
        Random random = new Random();
        for (String s : arr) {
            int ran = random.nextInt(1, 4);
            for (int j = 0; j < ran; j++) {
                list.add(s);
            }
        }
        return list;
    }
    static void countPlanets(String[] arr, List<String> list) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (arr[i].equals(list.get(j))){
                    System.out.println(arr[i] + " " + Collections.frequency(list, list.get(j)));
                    break;
            }
            }
        }
    }
}
