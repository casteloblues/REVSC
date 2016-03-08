/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import com.br.lp3.entities.FavoritosREVSC;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Castelo
 */
public class FavoritosREVSCDAO implements GenericDAO<FavoritosREVSC>{

    private EntityManager em;

    public FavoritosREVSCDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("REVSCPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public boolean create(FavoritosREVSC e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<FavoritosREVSC> readAll() {
        Query q = em.createQuery("SELECT f FROM FavoritosREVSC f");
        List<FavoritosREVSC> list = q.getResultList();
        return list;
    }

    @Override
    public FavoritosREVSC readByID(long idFav) {
        Query q = em.createQuery("SELECT f FROM FavoritosREVSC f WHERE f.idFav = :idFav");
        q.setParameter("idFav", idFav);
        return (FavoritosREVSC) q.getSingleResult();
    }

    @Override
    public boolean update(FavoritosREVSC e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(FavoritosREVSC e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        return true;
    }
    
}
