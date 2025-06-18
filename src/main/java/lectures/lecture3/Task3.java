package lectures.lecture3;

import java.io.*;
import java.util.ArrayList;

public class Task3 {
    /*
    Методы для работы с файлами в будущем
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Character.getName(i)); // достает символ по числу
        }
        serialObj(list, "src/lectures/lecture3/task3text");
        ArrayList<String> listNew = (ArrayList<String>) deSerialObj("src/lectures/lecture3/task3text");
        System.out.println(listNew);
    }

    public static void serialObj(Object o, String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }

    public static Object deSerialObj(String file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }
}
