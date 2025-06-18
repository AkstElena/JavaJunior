package lectures.lecture1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Привет", "мир", "!", "я", "родился", "!");

        List<String> list2 = list.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
        System.out.println(list2);

        list.stream().filter(str -> str.length() > 4).forEach(System.out::println); // сразу из потока выводим  эл-ты
        System.out.println("----------");
        list.stream().filter(str -> str.length() > 4).filter(str -> str.contains("о")).forEach(System.out::println); // сразу из потока выводим  эл-ты


        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().map(chislo ->"число: "+ chislo + ". квадарат числа: "  + chislo*chislo).forEach(System.out::println);
        Arrays.asList(1, 10, 35, 14, 5, 8, 3).stream().sorted().forEach(System.out::println); // можно по умолчанию сортировать, а можно самим составить
        System.out.println("----------");
        Arrays.asList(1, 10, 35, 14, 5, 8, 3, 8).stream().sorted().distinct().forEach(System.out::println); // можно при сортировке убрать дубликаты
        System.out.println(Arrays.asList(1, 10, 35, 14, 5, 8, 3, 8).stream().sorted().distinct().findFirst().get()); // терминальный метод, вернул первый элемент

    }
}
