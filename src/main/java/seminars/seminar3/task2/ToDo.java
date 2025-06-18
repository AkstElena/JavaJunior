package seminars.seminar3.task2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ToDo implements Externalizable { // используется вместо Serializable

//    private static final long seralVersionUID = 1L; // версия сериализатора, чтобы если класс изменился, то ее тоже изменить
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
    public ToDo() {
    }

    public ToDo(String title) {
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

    //region Externalizable impementation
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeBoolean(isDone);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        isDone = in.readBoolean();

    }

    //endregion
}
