/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.command;

import com.br.lp3.dao.UserRevSCDAO;
import com.br.lp3.entities.UserREVSC;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Castelo
 */
public class UserCommand implements Command {

    public HttpServletRequest req;
    public HttpServletResponse resp;
    public String retPage = "index.jsp"; //return page
    
    @Override
    public void init(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    @Override
    public void exec() {
        String action = req.getParameter("action");
        
        switch(action) {
            case "login":
                String username = req.getParameter("username");
                String pwd = req.getParameter("password");
                
                UserRevSCDAO uDAO = new UserRevSCDAO();
                UserREVSC user = uDAO.readByUsername(username);
                
                if(user != null && user.getPassword().equals(pwd)) {
                    req.getSession().setAttribute("username", username);
                    retPage = "index.jsp";
                } else {
                    req.getSession().setAttribute("errormsg", "Usuário inexistente ou senha incorreta");
                    retPage = "login.jsp";
                }
            break;
                
            case "logout":
                req.getSession().setAttribute("username", null);
                retPage = "index.jsp";
                break;
                
            case "reverbSearch":
                System.out.println("Teste sucesso");
                break;
        }
    }

    @Override
    public String getReturnPage() {
        return retPage;
    }
    
}
