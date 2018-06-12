/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.controller.impl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pettransport.controller.ControllerSessao;


/**
 *
 * @author masalas
 */
public class ControllerSessaoImpl implements ControllerSessao{
    
    @Override
    public boolean isLogado(HttpServletRequest req){
        HttpSession session=req.getSession(false);
        return session!=null && session.getAttribute("login")!=null;
    }
    
    @Override
    public void redirectLogin(HttpServletResponse resp){
        try {
            resp.sendRedirect("login");
        } catch (IOException ex) {
            Logger.getLogger(ControllerSessaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
