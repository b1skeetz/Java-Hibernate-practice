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

            Human human = manager.createQuery("select h from Human h where h.id = 4", Human.class).getSingleResult();
            human.getPassport().setPassportNumber(77777);

            Passport passport = manager.createQuery("select p from Passport p where p.person.id = 4", Passport.class).getSingleResult();
            System.out.println(passport.getPerson().getName());

            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
}