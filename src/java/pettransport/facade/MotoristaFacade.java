/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.facade;

import javax.servlet.http.HttpServletRequest;
import pettransport.controller.ControllerMotorista;
import pettransport.controller.impl.ControllerMotoristaImpl;
import pettransport.models.Motorista;

/**
 *
 * @author masalas
 */
public class MotoristaFacade {
    
    private ControllerMotorista controllerMotorista;
    
    public MotoristaFacade(){
        this.controllerMotorista = new ControllerMotoristaImpl();
    }

    public void adicionarMotoristaByRequest(HttpServletRequest req) {
        Motorista motorista = new Motorista();
        motorista.setNome(req.getParameter("nome"));
        motorista.setEmail(req.getParameter("email"));
        motorista.setTelefone(req.getParameter("telefone"));
        this.controllerMotorista.adicionarMotorista(motorista);
    }
    
    
    
}
