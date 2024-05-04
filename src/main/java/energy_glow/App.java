package energy_glow;

import energy_glow.model.Item;
import energy_glow.model.Person;
import energy_glow.utils.EntityManagerFactoryUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collections;
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

            Person person = new Person("Test", 30);

            Item newItem = new Item("Item3", person);

            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));

            manager.persist(person);

            manager.persist(newItem);

            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
}