package energy_glow;

import energy_glow.ManyToMany.Actor;
import energy_glow.ManyToMany.Movie;
import energy_glow.utils.EntityManagerFactoryUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.*;

public class App {
    public static void main(String[] args) {
        EntityManager manager = EntityManagerFactoryUtils.getEntityManagerFactory().createEntityManager();
        Scanner scanner = new Scanner(System.in);
        try (manager){
            manager.getTransaction().begin();

            Movie movie = new Movie("Pilp fiction", 1994);
            Actor actor1 = new Actor("Harvey Keitel", 81);
            Actor actor2 = new Actor("Samuel L. Jackson", 72);

            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));

            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));

            manager.persist(movie);


            manager.getTransaction().commit();
        }
    }
}