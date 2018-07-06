/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.controller;

import java.util.List;
import pettransport.models.Motorista;
import pettransport.models.Pet;
import pettransport.models.Requisicao;

/**
 *
 * @author masalas
 */
public interface ControllerRequisicao {
    
    public void adicionarRequisicao(Requisicao requisicao);
    
    public void atualizarRequisicao(Requisicao requisicao);
    
    public void deletarRequisicao(Requisicao requisicao);
    
    public List<Requisicao> getRequisicaoByMotorista(Motorista motorista);
    
    public Requisicao getRequisicaoByMotoristaPet(Motorista motorista, Pet pet);
          
}
