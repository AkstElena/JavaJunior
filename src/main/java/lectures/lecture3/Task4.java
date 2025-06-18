package lectures.lecture3;

import java.io.IOException;
import java.io.Serializable;

import static lectures.lecture3.Task3.deSerialObj;
import static lectures.lecture3.Task3.serialObj;

public class Task4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyFCs myFCs = new MyFCs("Ivanov", "Ivan", "Ivanovich");
        serialObj(myFCs, "src/lectures/lecture3/task4text"); // Но чтобы сериализовать объект, у класса должна быть прописана сериализация
        MyFCs myFCs1 = (MyFCs) deSerialObj("src/lectures/lecture3/task4text");
        System.out.println(myFCs1);

    }

    static class MyFCs implements Serializable { // если поля будут приватными, то сериализовать объект нельзя
        public String lName;
        public String fName;
        public String patronymic;

        public MyFCs(String lName, String fName, String patronymic) {
            this.lName = lName;
            this.fName = fName;
            this.patronymic = patronymic;
        }

        @Override
        public String toString() {
            return String.format("%s %s.%s.",
                fName,
                lName.toUpperCase().charAt(0), // только первую букву большую, с точкой
                patronymic.toUpperCase().charAt(0));
        }
    }
}
