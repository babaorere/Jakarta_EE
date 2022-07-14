package com.app.util;

import com.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateEliminar {


    public static void main(String[] args) {
        System.out.println("\n\nHibernateEliminar");

        final EntityManager em = JpaUtil.getEM();

        try {
            Long id = Long.valueOf(JOptionPane.showInputDialog("Id= ? ").trim());

            Cliente c = em.find(Cliente.class, id);

            if (c != null) {
                em.getTransaction().begin();
                em.remove(c);
                em.getTransaction().commit();
                System.out.println("\nCliente eliminado: " + c);
            } else {
                System.out.println("\nCliente no encontrado");
            }
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
