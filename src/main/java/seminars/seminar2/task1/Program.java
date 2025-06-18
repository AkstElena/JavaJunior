package seminars.seminar2.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {

    /**
     * Задача 1: Основы Reflection API
     * Получите информацию о классе "Person" с использованием Reflection API:
     * выведете на экран все поля и методы класса
     * Создайте экземпляр класса "Person" с использованием Reflection API,
     * установите значения полей и вызовите методы.
     * Реализуйте обработку исключний для обеспечения корректного взаимодействия с использованием Reflection API
     *
     */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> personalClass = Class.forName("seminars.seminar2.task1.Person"); //  с учетом пакте д.б. название

        // Получить список полей
        Field[] fields = personalClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Поле: " + field.getName());
        }

        // Получить список всех конструкторов
        Constructor[] constructors = personalClass.getConstructors();
        constructors[0].getParameters(); // какие параметры ожидает конструктор

        // Создать экземпляр класса
        Object personInstance = constructors[0].newInstance(); // подразумеваем что первый конструктор по умолчанию

        Field nameField = personalClass.getDeclaredField("name");
        nameField.setAccessible(true); // дает доступ к полю
        nameField.set(personInstance, "Alice"); //выдаст ошибку без предыдущей строки, так как пытаемся изменить приватное поле

        Field ageField = personalClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(personInstance, 30);

        Method displayInfoMethod = personalClass.getDeclaredMethod("displayInfo"); // получаем метод, зная его название
        displayInfoMethod.invoke(personInstance); // вызываем метод, первый параметр это объект на котором вызывается метод






    }
}
