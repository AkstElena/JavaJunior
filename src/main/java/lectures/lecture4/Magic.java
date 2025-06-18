package lectures.lecture4;


import javax.persistence.*;

@Entity // объект будет использваться при взаимодействие с ORM через Hibernate, при этом поля должны быть приватные,
// быть геттеры и сеттеры, пустой конструктор
@Table(name = "java_junior_lecture.magic") // связь класса с таблицей в БД
public class Magic {
    @Id // нанное поле является идентификатором
    @GeneratedValue(strategy = GenerationType.IDENTITY) // генерация ключа, автоинкремент
    private int id;

    @Column(name = "название") // задается название колонки
    private String name;

    @Column(name = "повреждение")
    private int damage;

    @Column(name = "атака")
    private int attBonus;

    @Column(name = "броня")
    private int armBonus;

    public Magic() {

    }

    public Magic(String name, int damage, int attBonus, int armBonus) {
        this.name = name;
        this.damage = damage;
        this.attBonus = attBonus;
        this.armBonus = armBonus;
    }

    @Override
    public String toString() {
        return "Magic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", attBonus=" + attBonus +
                ", armBonus=" + armBonus +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAttBonus(int attBonus) {
        this.attBonus = attBonus;
    }

    public void setArmBonus(int armBonus) {
        this.armBonus = armBonus;
    }
}
