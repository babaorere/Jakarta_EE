package com.app.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jakarta_ee9");
    }

    public static EntityManager getEM() {
        return emf.createEntityManager();
    }
}
