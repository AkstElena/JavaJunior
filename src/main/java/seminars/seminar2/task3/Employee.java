package seminars.seminar2.task3;

import java.util.UUID;

@Entity
@Table(name = "users") // класс отождествялется с таблицей в БД users
public class Employee {

    @Column(name = "id", primaryKey = true)  // сопоставляем поле с колонокой id в БД и оно первичный ключ
    private UUID id;

    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;

    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
