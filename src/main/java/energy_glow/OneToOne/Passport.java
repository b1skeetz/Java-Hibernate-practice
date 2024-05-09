package energy_glow.OneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "Passports")
@Getter
@Setter
public class Passport implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Human person;

    @Column(name = "passport_number")
    private int passportNumber;

    public Passport(){

    }

    public Passport(Human person, int passportNumber) {
        this.person = person;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "person=" + person +
                ", passportNumber=" + passportNumber +
                '}';
    }
}
