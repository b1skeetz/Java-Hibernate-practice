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

            Movie movie = new Movie("Reservoir Dogs", 1992);

            Actor actor = manager.createQuery("select a from Actor a where a.id = 4", Actor.class).getSingleResult();

            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
            actor.getMovies().add(movie);

            manager.persist(movie);

            manager.getTransaction().commit();
        }
    }
}