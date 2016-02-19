package com.br.lp3.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Castelo
 */
public class CommandImpl implements Command {

    public HttpServletRequest req;
    public HttpServletResponse resp;
    public String returnPage = "index.jsp";

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.req = request;
        this.resp = response;
    }

    @Override
    public void execute() {
        String action = req.getParameter("action");

        switch (action) {
            case "submit":
                String numEsc = req.getParameter("numEscolas");
                String numJ = req.getParameter("numJurados");
                req.getSession().setAttribute("numEsc", numEsc);
                req.getSession().setAttribute("numJ", numJ);
                returnPage = "preencher.jsp";
                break;
            case "preenchido":
                String notas = req.getParameter("nota");
                System.out.println(notas);
                returnPage = "resultado.jsp";
                break;
        }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }
}
