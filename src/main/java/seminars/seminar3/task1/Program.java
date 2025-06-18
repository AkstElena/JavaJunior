package seminars.seminar3.task1;

import java.io.*;

public class Program {
    /*
    Задача 1
    Создайте класс UserData с полями String name, int age, transient String password
    Поле password должно быть отмечено ключевым полем transient
    Реализуйте интерфейс Serializable в вашем классе
    В методе main создайте экземпляр класса UserData и инициализируйте его данными
    Сериализуйте этот объект в файл, используя ObjectOutputStream в сочетании с FileOutputStream

    Задача 2
    Десериализуйте объект из ранее созданного файла обратно в объект Java,
    используя ObjectInputStream в сочетании с FileInputStream
    Выведите данные десериализованного объекта UserData
    Сравните данные до сериализации и после, особенно обратите внимание на поле,
    помеченное как transient
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserData user = new UserData("Elena", 40, "123456");
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/seminars/seminar3/task1/userdata.bin")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            System.out.println("Объект UserData сериализован. ");
        }

        try (FileInputStream fileInputStream = new FileInputStream("src/seminars/seminar3/task1/userdata.bin")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            user = (UserData)objectInputStream.readObject();
            System.out.println("Объект UserData десериализован");
            System.out.println(user);
        }

    }
}
