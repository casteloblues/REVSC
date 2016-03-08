/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import java.util.List;

/**
 *
 * @author Castelo
 * @param <E> Entidade
 */
public interface GenericDAO<E> {
    public boolean create(E e);
    public List<E> readAll();
    public E readByID(long id);
    public boolean update(E e);
    public boolean delete(E e);
}
