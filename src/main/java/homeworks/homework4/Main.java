package homeworks.homework4;


/**
 * Задание: Настройте связь между вашим приложением и базой данных MySQL с использованием Hibernate.
 * Создайте несколько объектов Person и сохраните их в базу данных.
 */
public class Main {
    public static void main(String[] args) {
        DataBase.createRandomPersons(5);
        DataBase.createPerson("Елена", 40);
        DataBase.readDB();
        DataBase.updatePerson(5);
        DataBase.readDB();
        DataBase.deletePerson(2);
        DataBase.readDB();



    }
}
