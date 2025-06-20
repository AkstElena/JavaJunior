package seminars.seminar4.task1;

import lectures.lecture4.Connector;
import models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Program {
    private static final Random random = new Random();

    /**
     * Задача 1
     *
     * @param args Используя SQL, создайте таблицу students с полями id (ключ), name и age
     *             Реализация подключения базы данных ерез JDBC:
     *             Напишите Java-сод для подключения к база данных (например, MySQL или PostgreSQL)
     *             Реализуйте вставку, чтение, обновление и удаление данных в таблице Students
     *             с использованием провайдера JDBC
     */
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306";
//        String URL = "jdbc:mysql://students.db:3306"; // Для соединения двух контейнеров
        String USER = "Admin";
        String PASSWORD = "5EX-Aee89-Gra84";


        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) { // Подключение к базе данных

            // Создание БД
            createDatabase(connection);
            System.out.println("База данных успешно создана");

            // Использование БД
            useDatabase(connection);
            System.out.println("База данных используется");

            // Создание таблицы
            createTable(connection);
            System.out.println("Таблица успешно создана");

            // ДОбавление данных
            int count = 5 + random.nextInt(6);
            for (int i = 0; i < count; i++) {
                insertData(connection, Student.create());
            }
            System.out.println("Данные успешно добавлены");


            // Чтение данных
            Collection<Student> students = readData(connection);
            for (var student : students) {
                System.out.println(student);
            }
            System.out.println("Данные успешно прочитаны");


            // Обновление данных
            for (var student : students) {
                student.updateName();  // заранее сделали методы для случайного изменения имени и возраста
                student.updateAge();
                updateData(connection, student);
            }
            System.out.println("Данные успешно обновлены");


            // Чтение данных после обновления
            students = readData(connection);
            for (var student : students) {
                System.out.println(student);
            }
            System.out.println("Данные успешно прочитаны");

            // Удаление данных
           for (var student : students) {
                deleteData(connection, student.getId()); // проходим по всем данным и удаляем по id
            }
            System.out.println("Данные успешно удалены");


            // Закрытие соединения
//            connection.close();
//            System.out.println("База данных успешно закрыта");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    //region Вспомогательные методы
    private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS studentsDB";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL = "USE studentsDB";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }

    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(225), age INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

    /**
     * Добавление данных в таблицу students
     *
     * @param connection Соединение с БД
     * @param student    Студент
     * @throws SQLException Исключение при выполнение запроса
     */
    private static void insertData(Connection connection, Student student) throws SQLException {
        String insertDataSQL = "INSERT INTO students (name, age) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        }
    }

    /**
     * Чтение данных из таблицы students
     *
     * @param connection Соединение с БД
     * @return Коллекция студентов
     * @throws SQLException Исключение при выполнение запроса
     */

    private static Collection<Student> readData(Connection connection) throws SQLException {
        ArrayList<Student> studentsList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM students;";
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                studentsList.add(new Student(id, name, age));
            }
            return studentsList;
        }
    }


    /**
     * Обновление данных таблицы students по идентификатору
     *
     * @param connection Соединение с БД
     * @param student    Студент
     * @throws SQLException Исключение при выполнение запроса
     */
    private static void updateData(Connection connection, Student student) throws SQLException {
        String updateDataSQL = "UPDATE students SET name=?, age=? WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(updateDataSQL)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getId());
            statement.executeUpdate();
        }
    }

    /**
     * Удалене данных таблицы students по идентификатору
     *
     * @param connection Соединение с БД
     * @param id идентификатор запроса
     * @throws SQLException Исключение при выполнение запроса
     */
    private static void deleteData(Connection connection, int id) throws SQLException {
        String deleteDataSQL = "DELETE FROM students WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(deleteDataSQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }


    //endregion

}
