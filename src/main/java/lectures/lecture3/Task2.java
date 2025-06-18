package lectures.lecture3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Task2 {
    /*
    Извлечение объекта из файла
 */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("src/lectures/lecture3/ser"); // поток побайтового чтения из файла
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); // поток для загрузки объекта из файла
        String s = (String) objectInputStream.readObject(); // загружаем объект, тут привели к типу String, так как  не указано расширение, и загружается класс object
        System.out.println(s);
    }
}
