package com.gama.accenture.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("ecommerce");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
