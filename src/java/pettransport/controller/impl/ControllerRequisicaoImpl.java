/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.controller.impl;

import java.util.List;
import javax.persistence.Query;
import pettransport.controller.ControllerRequisicao;
import pettransport.dao.DAO;
import pettransport.dao.GenericDAO;
import pettransport.models.Motorista;
import pettransport.models.Pet;
import pettransport.models.Requisicao;

/**
 *
 * @author masalas
 */
public class ControllerRequisicaoImpl implements ControllerRequisicao {
    
    private DAO dao;
    
    public ControllerRequisicaoImpl(){
        this.dao = new GenericDAO();
    }

    @Override
    public void adicionarRequisicao(Requisicao requisicao) {
        this.dao.adicionarEntidade(requisicao);
    }

    @Override
    public void atualizarRequisicao(Requisicao requisicao) {
        this.dao.atualizarEntidade(requisicao);
    }

    @Override
    public void deletarRequisicao(Requisicao requisicao) {
        this.dao.deletarEntidade(requisicao);
    }

    @Override
    public List<Requisicao> getRequisicaoByMotorista(Motorista motorista) {
        Query query = this.dao.getEm().createQuery(
                "SELECT req FROM Requisicao req "+
                        "WHERE req.motorista = :mot");
        query.setParameter("mot", motorista);
        return (List) this.dao.findByQuery(query);
    }

    @Override
    public Requisicao getRequisicaoByMotoristaPet(Motorista motorista, Pet pet) {
        Query query = this.dao.getEm().createQuery(
                "SELECT req FROM Requisicao req "+
                        "WHERE req.motorista = :mot AND req.pet = :p");
        query.setParameter("mot", motorista);
        query.setParameter("p", pet);
        return (Requisicao) this.dao.findByQuery(query);
    }
    
}
