/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.web;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pettransport.controller.ControllerSessao;
import pettransport.controller.impl.ControllerSessaoImpl;
import pettransport.facade.MotoristaFacade;

/**
 *
 * @author masalas
 */
@WebServlet("/cadastromotorista")
public class CadastroMotoristaWeb extends HttpServlet {
    
    private ControllerSessao controllerSessao;
    private MotoristaFacade facade;
    
    public CadastroMotoristaWeb(){
        this.controllerSessao = new ControllerSessaoImpl();
        this.facade = new MotoristaFacade();
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
            switch(req.getParameter("acao")){
                case "add" : 
                    this.facade.adicionarMotoristaByRequest(req); 
                    this.doGet(req, resp);
                    break;
                case "atualizar":
                    break;
                case "del":
                    break;
                case "motoristas":
                    String json = new Gson().toJson(this.facade.getAll());
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write(json);
                    break;
            }
            
        }
    }
}
