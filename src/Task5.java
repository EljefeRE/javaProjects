// 5. Задано уравнение вида q+w=e,q,w,e>=0.Некоторые цифры могут быть заменены знаком вопроса,например,2?+?5=69.
// Требуется восстановить выражение до верного равенства.Предложить хотя бы одно решение или сообщить,что его нет.


import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        String equation = "2? + ?5 = 69";
        System.out.println("Исходное уравнение: " + equation);
        Solution(equation);
    }

    public static void Solution(String equation) {
        StringBuilder[] numbers = Splitting(equation);// выделяем слагаемые
        // #region подсчитаем число "?" в уравнении
        int QuestionCount = 0;
        for (int i = 0; i < equation.length(); i++)
            if (equation.charAt(i) == '?')
                QuestionCount++;
        // #endregion

        int MaxNumber = 1;
        for (int i = 0; i < QuestionCount; i++)
            MaxNumber *= 10;

        int Number = 0;
        do {//перебираем все возможные варианты.
            if (TryCase(numbers, Number))//решение найдено!
                return;
            Number++;
        } while (Number < MaxNumber);
        System.out.println("Нет решений!");
    }

    /**
     * подставляет заданные числа (из SomeNumbers) в уравнение вместо '?' и
     * проверяет равенство.
     *
     * @param numbers     закодированные 3 числа из уравнения
     * @param SomeNumbers число из которого берем числа для подстановки вместо ?
     * @return
     */
    public static boolean TryCase(StringBuilder[] numbers, int SomeNumbers) {
        StringBuilder[] CopyNumbers = new StringBuilder[3];
        for (int num = 0; num < 3; num++) {
            CopyNumbers[num] = new StringBuilder(numbers[num]);
            for (int i = 0; i < CopyNumbers[num].length(); i++) {
                if (CopyNumbers[num].charAt(i) == '?') {
                    CopyNumbers[num].replace(i, i + 1, Integer.toString(SomeNumbers % 10));
                    SomeNumbers /= 10;
                }
            }
        }
        if (Integer.parseInt(CopyNumbers[0].toString()) +
                Integer.parseInt(CopyNumbers[1].toString()) == Integer.parseInt(CopyNumbers[2].toString())) {
            System.out.println("Найдено решение!:");
            System.out.println(
                    CopyNumbers[0].append(" + ").append(CopyNumbers[1]).append(" = ").append(CopyNumbers[2]).toString());
            return true;
        }
        return false;
    }

    /**
     * Разделяет исходное уравнение вида "2? + ?5 = 69" на слагаемые
     *
     * @param equation - исходное уравнение вида "2? + ?5 = 69"
     * @return три слагаемых
     */
    public static StringBuilder[] Splitting(String equation) {
        StringBuilder[] numbers = new StringBuilder[3];
        for (int i = 0; i < 3; i++)
            numbers[i] = new StringBuilder();
        equation = equation.replace(" ", "");
        numbers[0] = new StringBuilder(equation.substring(0, equation.indexOf("+")));
        numbers[1] = new StringBuilder(equation.substring(equation.indexOf("+") + 1, equation.indexOf("=")));
        numbers[2] = new StringBuilder(equation.substring(equation.indexOf("=") + 1, equation.length()));
        return numbers;
    }
}



