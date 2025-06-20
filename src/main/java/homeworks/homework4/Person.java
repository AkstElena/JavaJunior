package homeworks.homework4;

import models.Student;

import javax.persistence.*;
import java.util.Random;


@Entity
@Table(name = "persons", schema="java_junior_persons_db")
public class Person  {

    private static final String[] names = {"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Максим",
            "Татьяна", "Ирина", "Мари", "Есения", "Влада", "Таисия"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    public String name;

    @Column(name = "age")
    public int age;


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static Person create() {
        return new Person(names[random.nextInt(names.length)], 18 + random.nextInt(33));
    }

    public void updateAge() {
        age = 18 + random.nextInt(33);
    }

    public void updateName() {
        name = names[random.nextInt(names.length)];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
