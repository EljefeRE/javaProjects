/* Дана json строка [{ "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
   {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Задача написать метод(ы), который распарсит строку и выдаст ответ вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
Используйте StringBuilder для подготовки ответа
Исходная json строка это просто String !!! Для работы используйте методы String, такие как replace, split, substring
        и т.д. по необходимости
Создать метод, который запишет результат работы в файл. Обработайте исключения и запишите ошибки в лог файл.
2. *Получить исходную json строку из файла, используя FileReader или Scanner
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Task {
    public static void main(String[] args) {
        String text = "[{ \"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        String newText = text.replaceAll("\\p{Punct}", " ");

        String[] words = newText.split("\\s*(\\s)\\s*");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            switch (words[i]) {
                case "фамилия" -> {
                    words[i] = "\nСтудент";
                    sb.append(words[i]);
                    sb.append(" ");
                }
                case "оценка" -> {
                    words[i] = "получил";
                    sb.append(words[i]);
                    sb.append(" ");
                }
                case "предмет" -> {
                    words[i] = "по предмету";
                    sb.append(words[i]);
                    sb.append(" ");
                }
                default -> {
                    sb.append(words[i]);
                    sb.append(" ");
                }
            }
        }
        System.out.println(sb);
        saveToFile(sb);
        readAFile();
    }

    static void saveToFile(StringBuilder s) {
        Logger logger = Logger.getLogger(Task.class.getName());
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        String path = "task.txt";

        try (FileWriter fileWriter = new FileWriter(path, false)) {
            fileWriter.write(s.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Тестовое логирование");
        }
        fileHandler.close();
    }

    static void readAFile() {
        BufferedReader reader = null;
        try (FileReader fileReader = new FileReader("task.txt")) {
            reader = new BufferedReader(fileReader);
            String line = null;

            ArrayList<String> list = new ArrayList<String>();

            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                list.add(line);
            }
            String[] stringArr = list.toArray(new String[0]);
            reader.close();

            String arrToStr = String.join(" ", stringArr);
            String[] words = arrToStr.split("\\s*(\\s)\\s*");
            StringBuilder sb = new StringBuilder();
            sb.append("[{");
            for (int i = 0; i < words.length; i++) {
                switch (words[i]) {
                    case "Студент" -> {
                        words[i] = "\"фамилия\":\"";
                        sb.append(words[i]);
                    }
                    case "получил" -> {
                        words[i] = "\"оценка\":\"";
                        sb.append(words[i]);
                    }
                    case "предмету" -> {
                        words[i] = "\"предмет\":\"";
                        sb.append(words[i]);
                    }
                    case "по" -> {
                        words[i] = "";
                        sb.append(words[i]);
                    }
                    case "" -> {
                        continue;
                    }
                    default -> {
                        sb.append(words[i]);
                        sb.append("\",");
                    }
                }
            }
            sb.append("\"}]");
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

