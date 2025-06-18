package seminars.seminar1.task1;
    /*
Задача 1: Реализовать систему учета книг в библиотеке. У каждой книги есть название, автор и год издания.
Необходимо создать список книг и выполнить следующие действия:
1. Обычный способ:
    - Найти все книги, написанные определенным автором (например, "John Dou").
    - Найти все книги, изданные после определнного года (например, 2010).
    - Найти все уникальные названия книг в бибилотеке.

2. Использование лямбда-выражений:
    - Те же самые задачи, но с использованием лямбда-выражений и Stream API для более компактного и выразительного кода
 */

import java.util.ArrayList;
import java.util.List;

public class LibraryV2 {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));


        // Поиск книг написанных автором
        System.out.println("Автор Александр Пушкин: ");
        books.stream().filter(book -> book.getAuthor().equalsIgnoreCase("Александр Пушкин")).forEach(System.out::println);

        // Поиск книг, изданных после определнного года
        System.out.println("Книги вышедшие начиная с 1866 года: ");
        books.stream().filter(book -> book.getYear() >= 1866).forEach(System.out::println);

        // Поиск уникальных названий книг
        System.out.println("Все уникальные названия книг в библиотеке: " +
                books.stream().map(book -> book.getTitle()).distinct().toList());

        System.out.println("Все уникальные названия книг в библиотеке: " +
                books.stream().map(Book::getTitle).distinct().toList()); // уже есть метод у объекта, поэтому можжно упростить


    }
}
