package seminars.seminar3.task1;

import java.io.Serializable;

public class UserData implements Serializable {
    String name;
    int age;
    transient String password; // данное поле не подлежит сериализации, чтобы не хранить

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserData(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;


    }

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
