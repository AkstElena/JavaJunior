package lectures.lecture2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Car car = new Car("BMW");

        // обходим невозможность создать класс по умолчанию, когда уже есть конструктор
        Class<?> car = Class.forName("lectures.lecture2.Car");

        // получаем через класс Конструтор информацию о всех конструкторах класса Car
        Constructor<?>[] constructors = car.getConstructors();

        // через создание объекта класса объект (наивысший в Java) создаем через конструктор объект нашего класса car
        Object gaz = constructors[0].newInstance("ГАЗ");

        System.out.println(car);
//        System.out.println(constructors);
        System.out.println(gaz);
        CarV2 carV2 = new CarV2("BMW");
        // обходим невозможность создать класс по умолчанию, когда уже есть конструктор
        Class<?> car2 = Class.forName("lectures.lecture2.CarV2");
        Constructor<?>[] constructors2 = car2.getConstructors();
        Object gaz2 = constructors2[0].newInstance("ГАЗ");
        System.out.println(gaz2);


        Field[] fields = gaz2.getClass().getFields();
        // Обходим отсутсвие методов и меняем значение последней переменной (поля),
        int tmp = fields[fields.length-1].getInt(gaz2);
        fields[fields.length-1].setInt(gaz2, tmp *= 2);
        System.out.println(gaz2);

//        // Выводим все методы класса
//        Method[] methods = gaz2.getClass().getMethods();
//        for (int i = 0; i < methods.length; i++) {
//            System.out.println(methods[i]);
//
//        }

        // Выводим все методы класса (бед методов Object)
        Method[] methods = gaz2.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);

        }


    }
}
