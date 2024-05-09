package energy_glow;

import energy_glow.utils.EntityManagerFactoryUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EntityManager manager = EntityManagerFactoryUtils.getEntityManagerFactory().createEntityManager();
        Scanner scanner = new Scanner(System.in);
        try {
            manager.getTransaction().begin();

            Query deleteHuman = manager.createQuery("delete from Human h where h.id = 4");
            deleteHuman.executeUpdate();

            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
}