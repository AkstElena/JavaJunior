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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Library {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));


        // Поиск книг написанных автором
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
//            if (book.getAuthor().equalsIgnoreCase("александр пушкин")) {
//                authorBooks.add(book);
//            }
            if ("александр пушкин".equalsIgnoreCase(book.getAuthor())) {
                authorBooks.add(book);
            }
        }
        System.out.println("Александр Пушкин: " + authorBooks);

        // Поиск книг, изданных после определнного года
        List<Book> yearsBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() >= 1866) {
                yearsBooks.add(book);
            }
        }

        // Поиск уникальных названий книг
        Set<String> booksWithUniqueTitle = new HashSet<>();
        for (Book book : books) {
            booksWithUniqueTitle.add(book.getTitle());
        }

//        List<String> booksWithUniqueTitle = new ArrayList<>();
//        for (Book book: books) {
//            if (!booksWithUniqueTitle.contains(book.getTitle())) {
//                booksWithUniqueTitle.add(book.getTitle());
//            }
//        }


        System.out.println("Александр Пушкин: " + authorBooks);
        System.out.println("Книги вышедшие начиная с 1866 года: " + yearsBooks);
        System.out.println("Все уникальные названия книг в библиотеке: " + booksWithUniqueTitle);


    }
}
