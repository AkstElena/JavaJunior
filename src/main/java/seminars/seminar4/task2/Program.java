package seminars.seminar4.task2;

import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Program {

    /**
     * Задача 2
     * Настройте Hibernate, связав его с вашей базой данных.
     * Создайте класс Student в Java, аннотируя его как сущность Hibernate.
     * Используя Hibernate, реализуйте вставку, чтение, обнослени и удаление данных в таблице students.
     * Обратите внимание на исполоание сессий и транзакций в Hibernate
     */
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class) // можно указать здесь класс для работы, не обязательно в конфиге
                .buildSessionFactory()) {

            // Создаение сесси
            Session session = sessionFactory.getCurrentSession();

            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Student student= Student.create();
            session.save(student); // сохраняем созданный объект
            System.out.println("Объект студент создан");

            // Чтение объекта из базы данных
            Student retrievedStudent = session.get(Student.class, student.getId()); // id взят из создания (выше)
            System.out.println("Чтение данных произошло успешно");
            System.out.println("Студент: " + retrievedStudent);

            // Обновление объекта
            retrievedStudent.updateName();
            retrievedStudent.updateAge();
            session.update(retrievedStudent);
            System.out.println("Данные по студенту обновлены");

            // Удаление объекта созданного выше
            session.delete(retrievedStudent);
            System.out.println("Данные по студенту удалены");



            // Подтверждение всех действий транзакции, добавление их в БД
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
