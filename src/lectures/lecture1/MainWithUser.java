package lectures.lecture1;

import java.util.Arrays;
import java.util.List;

public class MainWithUser {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Ivan", 35),
                new User("Mark", 24),
                new User("Mila", 21));

        // уменьшаем возраст юзеров на 5 лет и затем фильтруем только тех, кому меньше 25
        users.stream().map(user -> new User(user.name, user.age - 5)).filter(user -> user.age <= 25).forEach(System.out::println);
    }


}
