package com.app.util;

import com.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernateFindId {


    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final EntityManager em = JpaUtil.getEM();

        System.out.println("Ingrese el Id = ? ");
        Long id = sc.nextLong();

        Cliente c = em.find(Cliente.class, id); // cacheable
        em.close();

        System.out.println(c);
    }


}
