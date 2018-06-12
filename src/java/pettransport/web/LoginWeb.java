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
import javax.servlet.http.HttpSession;

/**
 *
 * @author masalas
 */
@WebServlet("/login")
public class LoginWeb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/login.jsp");
        rd.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
     
        if (email.equals("admin@hotmail.com") && senha.equals("admin")){    
            HttpSession sessao = req.getSession();
            sessao.setAttribute("login", "true");
            
            resp.sendRedirect("/Pettransport/");
        }
        else{
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/login.jsp");
            rd.forward(req, resp);
        }
    }
}
