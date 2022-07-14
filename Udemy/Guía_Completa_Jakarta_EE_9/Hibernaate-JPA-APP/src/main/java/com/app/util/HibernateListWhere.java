package com.app.util;

import com.app.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class HibernateListWhere {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEM();

        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.forma_pago=?1", Cliente.class);
        query.setParameter(1, "paypal");
        List<Cliente> list = (List<Cliente>) query.getResultList();
        em.close();

        list.forEach(System.out::println);
    }

}
