/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alana.weiss
 */
public class Run {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        /* PARA INSERIR NO BANCO
        final Cliente cliente = new Cliente(); 
        cliente.setId(1l);
        cliente.setNome("Carlos");

        em.getTransaction().begin();
        em.persist(cliente);
        
        em.getTransaction().commit();
        
        */
        //PARA BUSCAR UM CLIENTE
        final Cliente cliente = em.find(Cliente.class, 1l); 
        System.out.println(cliente.getNome());
        
        em.close();
        emf.close();
    }
}
