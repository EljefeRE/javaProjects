/*
1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
2. Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин,
Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова,
Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся
имена с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
 */
public class Task {
    public static void main (String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Иван", "12345");
        pb.add("Иван", "5421");
        pb.add("Петр", "3333222");
        pb.add("Сергей", "2121212");
        pb.add("Сергей", "3231122");
        pb.add("Олег", "911");
        System.out.println(pb.getByName("Иван"));
//        System.out.println(pb.getByNumber("5421"));
        System.out.println(pb.getAllList());

    }
}