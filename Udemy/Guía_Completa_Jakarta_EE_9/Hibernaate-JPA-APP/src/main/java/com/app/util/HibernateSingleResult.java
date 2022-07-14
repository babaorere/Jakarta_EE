package com.app.util;

import com.app.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class HibernateSingleResult {

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);

        final EntityManager em = JpaUtil.getEM();

        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.forma_pago=?1", Cliente.class);

        System.out.println("Forma de pago = ? ");
        String pago = sc.nextLine();

        query.setParameter(1, pago);
        query.setMaxResults(1);

        Cliente c = (Cliente) query.getSingleResult();

        em.close();

        System.out.println(c);
    }


}
