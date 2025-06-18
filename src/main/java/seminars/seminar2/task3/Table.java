package seminars.seminar2.task3;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // служебные аннотации, что аннотация ниже будет доступна в райнтайме для работы
@Target(ElementType.TYPE) // служебные аннотации: что аннотацию ниже можно применять только к конкретному типу
public @interface Table { // создаем, чтобы некоторые поля пометить, что ни будут полями таблицы БД

    String name();
}
