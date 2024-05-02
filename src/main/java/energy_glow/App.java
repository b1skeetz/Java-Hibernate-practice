package energy_glow;

import energy_glow.model.Item;
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

            TypedQuery<Person> selectPerson = manager.createQuery("select p from Person p where p.id = 2", Person.class);
            Person person = selectPerson.getSingleResult();

            Item newItem = new Item("Item from Hibernate", person);

            person.getItems().add(newItem); // не создает sql запрос, просто добавляет информацию в кэш

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
