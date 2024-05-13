package energy_glow;

import energy_glow.OneToMany.*;
import energy_glow.utils.EntityManagerFactoryUtils;
import jakarta.persistence.EntityManager;
import org.hibernate.Hibernate;

import java.util.*;

public class App {
    public static void main(String[] args) {
        EntityManager manager = EntityManagerFactoryUtils.getEntityManagerFactory().createEntityManager();
        Scanner scanner = new Scanner(System.in);
        try (manager){
            manager.getTransaction().begin();

            Person person = manager.createQuery("select p from Person p where p.id = 3", Person.class).getSingleResult();
            System.out.println("Получили человека");

            Hibernate.initialize(person.getItems());

            manager.getTransaction().commit();

            System.out.println(person.getItems());
        }
    }
}