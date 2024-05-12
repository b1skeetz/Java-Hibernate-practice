package energy_glow.OneToOne;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "Humanity")
@Getter
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Passport passport;

    public Human(){

    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
        passport.setPerson(this);
    }
}