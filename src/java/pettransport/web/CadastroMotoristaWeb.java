/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pettransport.controller.ControllerSessao;
import pettransport.controller.impl.ControllerSessaoImpl;

/**
 *
 * @author masalas
 */
@WebServlet("/cadastromotorista")
public class CadastroMotoristaWeb extends HttpServlet {
    
    ControllerSessao controllerSessao;
    
    public CadastroMotoristaWeb(){
        this.controllerSessao = new ControllerSessaoImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.controllerSessao.isLogado(req)){
            this.controllerSessao.redirectLogin(resp);
        }
        else{
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/cadastro_motorista.jsp");
            rd.forward(req, resp);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        if (!this.controllerSessao.isLogado(req)){
            this.controllerSessao.redirectLogin(resp);
        }
        else{
            for(String chave : req.getParameterMap().keySet()){
                System.out.print(chave+": ");
                System.out.println(req.getParameter(chave));
            }
        
            this.doGet(req, resp);
        }
    }
}
