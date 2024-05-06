package energy_glow.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtils {
    private static EntityManagerFactory entityManagerFactory;

    private EntityManagerFactoryUtils(){

    }

    public static EntityManagerFactory getEntityManagerFactory(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
        }
        return entityManagerFactory;
    }
}