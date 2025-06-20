package lectures.lecture4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class DbHibernate {


    // сохранение в БД
    public static void con() {
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml, формируем связь с сервером БД
//                .build();
//        // сформировалась сессия с БД
//        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        // создаем объект, через конструктор, а не через SQL запрос
//        Magic magic = new Magic("Волшебная стрела", 10, 0);
//        session.beginTransaction();
//        session.save(magic); // сохранение сущности в БД
//        session.getTransaction().commit(); // завершаем транзакцию
//        session.close(); // закрытие сессии
        Connector connector = new Connector();
        Session session = connector.getSession();
        Magic magic = new Magic("Волшебная стрела", 10, 0, 0);
        session.beginTransaction();
        session.save(magic);
        magic = new Magic("Молния", 25, 0, 0);
        session.save(magic);
        magic = new Magic("Каменная кожа", 0, 0, 6);
        session.save(magic);
        magic = new Magic("Жажда крови", 0, 6, 0);
        session.save(magic);
        magic = new Magic("Жажда крови", 0, 6, 0);
        session.save(magic);
        magic = new Magic("Проклятие", 0, -3, 0);
        session.save(magic);
        magic = new Magic("Лечение", -30, 0, 0);
        session.save(magic);
        session.getTransaction().commit();
        session.close();
    }

    // извлечение из БД
    public static void fromCon() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            // в запросе указываем таблицу из БД, а затем название класса с помощью которого формируем объекты
            List<Magic> books = session.createQuery("FROM Magic", Magic.class).getResultList();
            books.forEach(b -> {
                System.out.println("Book of Magic : " + b);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // изменение объекта БД
    public static void changeCon() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            String hql = "from Magic where id = :id";
            // создаем запрос
            Query<Magic> query = session.createQuery(hql, Magic.class);
            query.setParameter("id", 4);
            Magic magic = query.getSingleResult();
            System.out.println(magic);
            magic.setAttBonus(100);
            magic.setName("Ярость");
            session.beginTransaction();
            session.update(magic);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteCon() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Transaction t = session.beginTransaction();
            List<Magic> books = session.createQuery("FROM Magic", Magic.class).getResultList();
            books.forEach(session::delete);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
