package com.app.util;

import com.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateEditar {

    public static void main(String[] args) {
        System.out.println("\n\nHibernateEditar");

        final EntityManager em = JpaUtil.getEM();

        try {
            Long id = Long.valueOf(JOptionPane.showInputDialog("Id= ? ").trim());

            Cliente c = em.find(Cliente.class, id);

            if (c != null) {
                String nombre = JOptionPane.showInputDialog("Nombre= ? ", c.getNombre()).trim();
                String apellido = JOptionPane.showInputDialog("Apellido= ? ", c.getApellido()).trim();
                String forma_pago = JOptionPane.showInputDialog("Forma de pago= ? ", c.getForma_pago()).trim();

                c.setNombre(nombre);
                c.setApellido(apellido);
                c.setForma_pago(forma_pago);

                em.getTransaction().begin();
                em.merge(c);
                em.getTransaction().commit();
                System.out.println("\nCliente editado: " + c);
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
