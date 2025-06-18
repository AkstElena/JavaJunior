package lectures.lecture1;

public class Main {
    public static void main(String[] args) {


//        PlainInterface plainInterface = new PlainInterface() { // можно создать объект интерфеса, переопределив метод
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x + y); // преобразовываем число к строке, так как на выходе нужна строка
//            }
//        };

        PlainInterface plainInterface = (x, y) -> String.valueOf(x + y);  // реализация через лямбда выражение
        PlainInterface plainInterface2 = (x, y) -> {
            return String.valueOf(x + y);
        };  // реализация через лямбда выражение, если в несколько строк то нужно return

        System.out.println(plainInterface.action(2, 3));
        System.out.println(plainInterface2.action(3, 5));

        PlainInterface plainInterface1 = (x, y) -> String.valueOf(Integer.compareUnsigned(x, y)); // уже другая логика закладывается в метод интерфейса

        System.out.println(plainInterface1.action(3, 5));  // выйдет -1, если первое число меньше
        System.out.println(plainInterface1.action(5, 3));  // выйдет 1, если первое число больше


        Plain2Interface plain2Interface = (x, y) -> (x + y);  // реализация второго интерфейса
        Plain2Interface plain2Interface4 = Integer::sum;  // метод sum как объект, так как ожидает Integer, то его указываем и указываем что делать
        Plain2Interface plain2Interface5 = Integer::max;  // можно любое действие, допустимое с двумя цифрами
        Plain2Interface plain2Interface1 = (x, y) -> Integer.compareUnsigned(x, y); // уже другая логика закладывается в метод интерфейса
        Plain2Interface plain2Interface3 = Integer::compare; // позволяет улучшить/сократить код, в связи с функцианальным методом интерфейса,  compare можно рассматривать как объект


        System.out.println(plain2Interface.action(2, 3));
        System.out.println(plain2Interface1.action(3, 5));  // выйдет -1, если первое число меньше
        System.out.println(plain2Interface3.action(3, 5));  // выйдет -1, если первое число меньше
        System.out.println(plain2Interface4.action(3, 5));  // сложит
        System.out.println(plain2Interface5.action(3, 5));  // выдаст макисимальное
    }
}