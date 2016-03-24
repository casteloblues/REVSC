/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.command;

import com.br.lp3.controller.Manager;
import com.br.lp3.dao.UserRevSCDAO;
import com.br.lp3.entities.InstREVSC;
import com.br.lp3.entities.UserREVSC;
import java.util.List;
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
        switch (action) {
            case "login":
                String username = req.getParameter("username");
                String pwd = req.getParameter("password");
                
                UserRevSCDAO uDAO = new UserRevSCDAO();
                UserREVSC user = uDAO.readByUsername(username);
                
                if (user != null && user.getPassword().equals(pwd)) {
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
                String queryFull = req.getParameter("query");
//                System.out.println(queryFull);
                req.setAttribute("queryFull", queryFull);
                retPage = "reverbSearch.jsp";
                break;
                
            case "reverbSearchDetail":
                req.setAttribute("brand", req.getParameter("brand"));
                req.setAttribute("model", req.getParameter("model"));
                req.setAttribute("year_max", req.getParameter("year_max"));
                req.setAttribute("year_min", req.getParameter("year_min"));
//                String urlComp = "https://reverb.com/?query=" + req.getParameter("brand") + "+" + req.getParameter("model") +
//                        "&x=11&y=5";
                String urlComp = "https://reverb.com/api/listings/all?make=" + req.getParameter("brand") +
                        "&model=" + req.getParameter("model") + "&year_max=" + req.getParameter("year_max") +
                        "&year_min=" + req.getParameter("year_min");
                
//                System.out.println(urlComp);
//                
//                String queryC = req.getParameter("brand") + "+" + req.getParameter("model");
//                System.out.println(queryC);
//                req.setAttribute("queryC", queryC);
                
                
                List<InstREVSC> instList = Manager.JsonBuild(urlComp);
                
//                for (int i = 0; i < instList.size(); i++) {
//                    System.out.println(instList.get(i).getTitle());
//                }
                
                req.setAttribute("instList", instList);
                retPage = "reverbSearch.jsp";
                break;
        }  

    }

    @Override
    public String getReturnPage() {
        return retPage;
    }

}
