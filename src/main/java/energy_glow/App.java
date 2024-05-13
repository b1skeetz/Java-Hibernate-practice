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
        try{
            manager.getTransaction().begin();

            Person person = manager.createQuery("select p from Person p where p.id = 3", Person.class).getSingleResult();
            System.out.println("Получили человека");


            manager.getTransaction().commit();
            System.out.println("Сессия закончилась");


            manager.getTransaction().begin();
            System.out.println("Внутри второй транзакции");

//            person = manager.merge(person);

//            Hibernate.initialize(person.getItems());
            List<Item> items = manager.createQuery("select i from Item i where i.owner.id = :personId", Item.class)
                    .setParameter("personId", person.getId()).getResultList();

            manager.getTransaction().commit();

            System.out.println("Вне второй сессии");

            System.out.println(items);

        } catch (Exception e){
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
}