/*
1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
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
        System.out.println("Поиск по имени: " + pb.getByName("Иван"));
        System.out.println("Поиск по номеру: " + pb.getByNumber("911"));
        System.out.println(pb.getAllList());

    }
}