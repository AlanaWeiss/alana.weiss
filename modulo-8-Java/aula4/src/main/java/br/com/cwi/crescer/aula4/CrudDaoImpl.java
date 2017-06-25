/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula4;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author alana'
 */
public class CrudDaoImpl<T, ID> implements Dao<T, ID> {

    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    final EntityManager em = emf.createEntityManager();
    final Session session;
    final Class<T> classe;

    public CrudDaoImpl(Class<T> classe) {
        this.classe = classe;
        this.session = em.unwrap(Session.class);
    }

    @Override
    public T save(T e) {

        session.getTransaction().begin();
        session.save(e);
        session.getTransaction().commit();

        return e;
    }

    @Override
    public void remove(T e) {
        session.getTransaction().begin();
        session.delete(e);
        session.getTransaction().commit();
    }

    @Override
    public T loadById(ID id) {
        return em.find(classe, id);
    }

    @Override
    public List<T> findAll() {
        return session.createCriteria(classe).list();
    }

}
