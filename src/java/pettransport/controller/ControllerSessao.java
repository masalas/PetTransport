/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author masalas
 */
public interface ControllerSessao {
    
    public boolean isLogado(HttpServletRequest req);
    
    public void redirectLogin(HttpServletResponse resp);

}