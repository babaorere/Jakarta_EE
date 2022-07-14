package com.app.util;

import com.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.Scanner;

public class HibernateCrear {

    public static void main(String[] args) {
        System.out.println("HibernateCrear");

        final Scanner sc = new Scanner(System.in);
        final EntityManager em = JpaUtil.getEM();

        try {
            String nombre = JOptionPane.showInputDialog("Nombre= ? ").trim();
            String apellido = JOptionPane.showInputDialog("Apellido= ? ").trim();
            String forma_pago = JOptionPane.showInputDialog("Forma de pago= ? ").trim();

            Cliente c = new Cliente(nombre, apellido, forma_pago);
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            System.out.println("\nCliente agregado: " + c);
        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }

    }

}
