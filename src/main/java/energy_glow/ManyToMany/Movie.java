package energy_glow.ManyToMany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Movies")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int year;


    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Actor> actors;
    public Movie(){

    }

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year && Objects.equals(id, movie.id) && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}