package models;



import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "students")

public class Student {

    private static final String[] names = {"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Максим", "Татьяна", "Ирина", "Мари", "Есения", "Влада", "Таисия"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Student create() {
        return new Student(names[random.nextInt(names.length)], 20 + random.nextInt(6));
    }

    public void updateAge() {
        age = 20 + random.nextInt(6);
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
