package homeworks.homework2;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/*
Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.
 */
public class Main {
    public static void main(String[] args) {


        Method[] methods = String.class.getMethods();  // публичные и унаследованные методы класса String
        Method[] declaredMethods = String.class.getDeclaredMethods(); // публичные и непубличные методы класса String


        Set<String> uniqueMethods = new HashSet<>();
        for (Method method : methods) {
            uniqueMethods.add(method.getName());
        }
        for (Method declaredMethod : declaredMethods) {
            uniqueMethods.add(declaredMethod.getName());
        }

        System.out.println("Все методы класса String: ");
        int i = 0;
        for (String uniqueMethod : uniqueMethods) {
            i++;
            System.out.printf("%s) %s\n", i, uniqueMethod);
        }


    }

}
