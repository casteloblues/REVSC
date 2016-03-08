/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import com.br.lp3.entities.InfoUREVSC;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Castelo
 */
public class InfoUREVSCDAO implements GenericDAO<InfoUREVSC>{

    private EntityManager em;

    public InfoUREVSCDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("REVSCPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public boolean create(InfoUREVSC e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(InfoUREVSC e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(InfoUREVSC e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<InfoUREVSC> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InfoUREVSC readByID(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
