package energy_glow;

import energy_glow.model.Person;
import energy_glow.utils.EntityManagerFactoryUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;
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

            TypedQuery<Person> getPeople = manager.createQuery("from Person where name like 'C%'", Person.class);
            List<Person> people = getPeople.getResultList();

            for (Person person : people) {
                System.out.println(person);
            }

            Query updateNames = manager.createQuery("delete from Person p where age = 20");
            updateNames.executeUpdate();

            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
}
