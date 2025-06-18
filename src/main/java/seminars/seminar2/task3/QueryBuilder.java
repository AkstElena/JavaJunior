package seminars.seminar2.task3;

import java.lang.reflect.Field;
import java.util.UUID;

public class QueryBuilder {
    public String buildInsertQuery(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();  // через мехнизм рефлексии выяснем что за объект у нас
        StringBuilder query = new StringBuilder("INSERT INFO "); // создаем динамическую строку, будем дополнять


        if (clazz.isAnnotationPresent(Table.class)) { // спрашиваем, есть ли аннотация таблица
            Table tableAnnotation = clazz.getAnnotation(Table.class);  // получаем аннотацию и далее формируем стандартный запрос на добавление
            query.append(tableAnnotation.name()).append(" ("); // Добавляем в динамическую строку название таблицы


            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) { // для каждого поля уточняем есть ли аннотация колонка
                if (field.isAnnotationPresent(Column.class)) {
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    query.append(columnAnnotation.name()).append(", ");
                }

            }
            // убираем последнюю запятую с пробелом
            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }

            query.append(") VALUES (");

            for (Field field : fields) { // для каждого поля уточняем есть ли аннотация колонка
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true); // разрешаем доступ к закрытому полю
                    query.append("'").append(field.get(obj)).append("', ");
                }

            }
            // убираем последнюю запятую с пробелом
            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length() - 1);
            }

            query.append(")");
            return query.toString();


        } else {
            return null;
        }
    }


    //  в данном варианте даже сам объет не передается, а передается первичный клю
    public String buildSelectQuery(Class<?> clazz, UUID primaryKey) {
        StringBuilder query = new StringBuilder("SELECT * FROM ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" WHERE ");

        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey()) {
                    query.append(columnAnnotation.name()).append(" = ").append(primaryKey);
                    break;
                }
            }
        }
        return query.toString();
    }


    public String buildUpdateQuery(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("UPDATE ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" SET ");


            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    if (columnAnnotation.primaryKey()) {
                        continue;
                    }
                    query.append(columnAnnotation.name()).append(" = '").append(field.get(obj)).append("', ");
                }

            }
            // убираем последнюю запятую с пробелом
            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length() - 1);
            }

            query.append(" WHERE ");

            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    if (columnAnnotation.primaryKey()) {
                        query.append(columnAnnotation.name()).append(" = '").append(field.get(obj)).append("'");
                        break;
                    }
                }
            }

            return query.toString();


        } else {
            return null;
        }
    }

/*
Домашнее задание
 */
    public String buildDeleteQuery(Class<?> clazz, UUID primaryKey) {
        StringBuilder query = new StringBuilder("DELETE FROM ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" WHERE ");

        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey()) {
                    query.append(columnAnnotation.name()).append(" = ").append(primaryKey);
                    break;
                }
            }
        }
        return query.toString();

    }


}
