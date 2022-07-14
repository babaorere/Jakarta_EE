package com.app.util;

import com.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateList {


    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEM();

        List<Cliente> list = em.createQuery("SELECT c from Cliente c", Cliente.class).getResultList();

        list.forEach(System.out::println);

        em.close();
    }
}
