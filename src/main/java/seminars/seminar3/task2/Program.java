package seminars.seminar3.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static seminars.seminar3.task2.ToDoListApp.*;

public class Program {
    /*
    Разработать простейшее приложение, аналог приложения ToDoList
    То есть ставятся некоторые задачи
    У каждой задачи должны быть состояния: выполнена, не выполнена
    В рамках приложения отмечаются выполненные задачи
    Так же необходимо сделать его не одноразовым, то есть при завершении приложения
    состояния задач сохраняется в локальном файле
    Чтобы данные были сериализованы не только в рамках бинарного файла,
    но и была возможность редактировать сам файл
     */
    public static void main(String[] args) {
        List<ToDo> tasks;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory())
            tasks = loadTasksFromFile(FILE_JSON);
        else
            tasks = prepareTasks();
        ToDoListApp.saveTasksToFile(FILE_JSON, tasks);
        ToDoListApp.saveTasksToFile(FILE_BIN, tasks);
        ToDoListApp.saveTasksToFile(FILE_XML, tasks);

        displayTasks(tasks);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие: ");
            System.out.println("1. Добавить новую задачу");
            System.out.println("2. Отметить задачу как выполненную");
            System.out.println("3. Выйти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    ToDoListApp.addNewTask(scanner, tasks);
                    break;
                case "2":
                    ToDoListApp.markTaskAsDone(scanner, tasks);
                    break;
                case "3":
                    ToDoListApp.saveTasksToFile(FILE_JSON, tasks);
                    ToDoListApp.saveTasksToFile(FILE_BIN, tasks);
                    ToDoListApp.saveTasksToFile(FILE_XML, tasks);
                    System.out.println("Список задач сохранен.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }

            displayTasks(tasks);
        }


    }

    static List<ToDo> prepareTasks() {
        ArrayList<ToDo> list = new ArrayList<>();
        list.add(new ToDo("Сходить в магазин за продуктами"));
        list.add(new ToDo("Погулять с собакой"));
        list.add(new ToDo("Заменить лампочку"));
        return list;
    }
}
