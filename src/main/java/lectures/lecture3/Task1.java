package lectures.lecture3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Task1 {
    /*
    Запись объекта в файл
     */
    public static void main(String[] args) throws IOException {
        String str = "Всем привет!";
        FileOutputStream fileOutputStream = new FileOutputStream("src/lectures/lecture3/ser");  // создание потока записи байт в файл
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); // создание потока объекта в файл
        objectOutputStream.writeObject(str); // запись
        objectOutputStream.close(); // закрытие потока
    }
}
