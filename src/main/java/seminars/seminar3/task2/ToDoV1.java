package seminars.seminar3.task2;

import java.io.Serializable;

public class ToDoV1 implements Serializable {

    //region Поля
    /**
     * Наименование задачи
     */
    private String title;


    /**
     * Статус задачи
     */
    private boolean isDone;

    //endregion

    //region Конструкторы
    public ToDoV1() {
    }

    public ToDoV1(String title) {
        this.title = title;
        isDone = false;
    }
    //endregion

    //region Методы

    /**
     * Получить наименование задачи
     * @return наименование задачи
     */
    public String getTitle() {
        return title;
    }

    /**
     * Получить статус выполнения задачи
     * @return статус выполнения задачи
     */
    public boolean isDone() {
        return  isDone;
    }


    /**
     * Изменить статус выполнения задачи
     * @return done новый статус задачи
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    //endregion

}