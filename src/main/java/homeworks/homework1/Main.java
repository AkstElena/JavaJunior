package homeworks.homework1;

import java.util.Arrays;
import java.util.List;

/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 25, 45, 14, 2, 1, 55, 4, 12, 8);
        System.out.println("Исходный список чисел: " + numbers);

        System.out.println("Все четные числа списка: " + numbers.stream().filter(number -> (number % 2) == 0).toList());

        System.out.println("Среднее значение четных чисел списка: " +
                numbers.stream().filter(number -> (number % 2) == 0).mapToDouble(Integer::doubleValue).average().orElse(Double.NaN));

    }
}
