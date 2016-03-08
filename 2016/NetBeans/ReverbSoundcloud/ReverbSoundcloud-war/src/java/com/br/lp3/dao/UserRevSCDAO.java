/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import com.br.lp3.entities.UserREVSC;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Castelo
 */
public class UserRevSCDAO implements GenericDAO<UserREVSC> {

    private EntityManager em;
    
    public UserRevSCDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("REVSCPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public boolean create(UserREVSC e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<UserREVSC> readAll() {
        Query q = em.createQuery("SELECT u FROM UserREVSC u");
        List<UserREVSC> list = q.getResultList();
        return list;
    }

    @Override
    public UserREVSC readByID(long id) {
        Query q = em.createQuery("SELECT u FROM UserREVSC u WHERE u.idUser = :id");
        q.setParameter("id", id);
        return (UserREVSC) q.getSingleResult();
    }
    
    public UserREVSC readByUsername(String username) {
        Query q = em.createQuery("SELECT u FROM UserREVSC where u.username = :username");
        q.setParameter("username", username);
        return (UserREVSC) q.getSingleResult();
    }

    @Override
    public boolean update(UserREVSC e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(UserREVSC e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        return true;
    }
    
}
