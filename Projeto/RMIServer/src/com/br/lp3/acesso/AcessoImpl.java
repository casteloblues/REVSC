/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.acesso;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Castelo
 */
public class AcessoImpl extends UnicastRemoteObject implements Acesso {

    private String nome;
    private int pswd;
    private List<String> users;

    public AcessoImpl() throws RemoteException {
        users = new ArrayList<>();
    }

    @Override
    public void newUser(String nome, Integer pswd) throws RemoteException {
        this.nome = nome;
        this.pswd = pswd;

        if (!check(nome, pswd)) {
            //implementar como irá persistir na base de dados
        } else {
            System.out.println("Usuário já existe, escolha outro nome de usuário…");
        }
    }

    @Override
    public void connect(String nome, Integer pswd) throws RemoteException {
        this.nome = nome;
        this.pswd = pswd;

        if (!check(nome, pswd)) {
            users.add(nome);
        } else {
            System.out.println("Já conectado");
        }
    }

    @Override
    public void disconnect(String nome) throws RemoteException {
        users.remove(nome);
        this.nome = "";
    }

    @Override
    public List<String> getUsuarios() throws RemoteException {
        return users;
    }

    public boolean check(String nome, Integer pswd) { //pswd = password
        boolean resp = false;
        for (String user : users) {
            if (user.equals(nome)) {
                if (user.equals(pswd)) {
                    resp = true;
                    break;
                }
            }
        }
        return resp;
    }
}