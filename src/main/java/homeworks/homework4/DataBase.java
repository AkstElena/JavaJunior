package homeworks.homework4;


import models.Student;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    /**
     * Выгрузка из БД
     */

    public static void readDB() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
            criteria.from(Person.class);
            List<Person> persons = session.createQuery(criteria).getResultList();
            persons.forEach(System.out::println);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Добавление рнадомных person в базу данных
     *
     * @param count количество person которые надо добавить в базу данных
     */
    public static void createRandomPersons(int count) {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            session.beginTransaction();
            for (int i = 0; i < count; i++) {
                Person person = Person.create();
                session.save(person);
            }
            System.out.println("Данные успешно добавлены");
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Добавление person в БД по имени и возрасту
     *
     * @param name имя
     * @param age  возраст
     */
    public static void createPerson(String name, int age) {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            session.beginTransaction();
            Person person = new Person(name, age);
            session.save(person);
            System.out.println("Данные успешно добавлены");
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Обновление по идентификтору
     * @param id идентификатор по котору произойдет обновление
     */
    public static void updatePerson(int id) {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, id); //
            System.out.println("Чтение данных произошло успешно");
            System.out.println("Персона: " + person);
            person.updateName();
            person.updateAge();
            session.update(person);
            System.out.println("Данные по перосоне обновлены");
            System.out.println("Персона: " + person);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePerson(int id) {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.delete(person);
            System.out.println("Данные по персоне удалены");
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
