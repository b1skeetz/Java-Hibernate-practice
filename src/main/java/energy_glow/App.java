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

            Actor actor = manager.createQuery("select a from Actor a where a.id = 5", Actor.class).getSingleResult();
            System.out.println(actor.getMovies());

            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(movieToRemove);
            movieToRemove.getActors().remove(actor);

            manager.getTransaction().commit();
        }
    }
}