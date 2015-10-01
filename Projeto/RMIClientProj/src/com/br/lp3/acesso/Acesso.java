/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.acesso;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Castelo
 */
public interface Acesso extends Remote {
    public void newUser (String nome, Integer pswd) throws RemoteException;
    public void connect(String nome, Integer pswd) throws RemoteException;
    public void disconnect(String nome) throws RemoteException;
    
    public List<String> getUsuarios() throws RemoteException;
}
