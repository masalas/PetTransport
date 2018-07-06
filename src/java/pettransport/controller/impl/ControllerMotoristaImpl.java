/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.controller.impl;

import java.util.List;
import pettransport.controller.ControllerMotorista;
import pettransport.dao.DAO;
import pettransport.dao.GenericDAO;
import pettransport.models.Motorista;

/**
 *
 * @author masalas
 */
public class ControllerMotoristaImpl implements ControllerMotorista{
    
    private DAO dao;
    
    public ControllerMotoristaImpl(){
        this.dao = new GenericDAO();
    }
    
    @Override
    public void adicionarMotorista(Motorista motorista) {
        this.dao.adicionarEntidade(motorista);
    }
    
    @Override
    public List<Motorista> buscarTodos(){
        return (List) this.dao.findAll(Motorista.class);
    }

    @Override
    public Motorista buscarPorId(int id) {
        return (Motorista) this.dao.findById(Motorista.class, id);
    }
    
    
    
}
