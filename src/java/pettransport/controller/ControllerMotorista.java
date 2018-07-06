/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.controller;

import java.util.List;
import pettransport.models.Motorista;

/**
 *
 * @author masalas
 */
public interface ControllerMotorista {
    
       
    public void adicionarMotorista(Motorista motorista);
    
    public List<Motorista> buscarTodos();
    
    public Motorista buscarPorId(int id);
    
    
}
