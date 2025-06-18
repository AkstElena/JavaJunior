package lectures.lecture4;

import java.sql.*;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "Admin";
    private static final String PASSWORD = "5EX-Aee89-Gra84";

    public static void con() {
        // создаем подключение к базе данных
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
            // работаем с бд
            Statement statement = con.createStatement();
            statement.execute("DROP SCHEMA `java_junior_lecture`"); // можно создавать запросы к базе данных
            statement.execute("CREATE SCHEMA `java_junior_lecture`");
            statement.execute("CREATE TABLE `java_junior_lecture`.`table` (`id` INT NOT NULL, " +
                    "`firstname` VARCHAR(45) NULL, `lastname` VARCHAR(45) NULL, PRIMARY KEY (`id`));");
            statement.execute("INSERT INTO `java_junior_lecture`.`table` (`id`,`firstname`,`lastname`)" +
                    " VALUES (1,'Иванов','Иван');");
            statement.execute("INSERT INTO `java_junior_lecture`.`table` (`id`,`firstname`,`lastname`)" +
                    " VALUES (2,'Петров','Петр');");

            // создаем запросы из таблицы
            ResultSet set = statement.executeQuery("SELECT * FROM java_junior_lecture.table;");
            while (set.next()) {
                // номер колонки
                System.out.println(set.getString(3) + " " + set.getString(2)
                        + " " + set.getInt(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
