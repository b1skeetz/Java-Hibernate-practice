package energy_glow;

import energy_glow.OneToMany.*;
import energy_glow.OneToOne.*;
import energy_glow.utils.EntityManagerFactoryUtils;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EntityManager manager = EntityManagerFactoryUtils.getEntityManagerFactory().createEntityManager();
        Scanner scanner = new Scanner(System.in);
        try {
            manager.getTransaction().begin();

            Human human = new Human("Nick", 66);
            Passport passport = new Passport(human, 98765);

            human.setPassport(passport);

            manager.persist(human);

            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
}