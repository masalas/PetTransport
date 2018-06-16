/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.controller.impl;

import pettransport.controller.ControllerPet;
import pettransport.dao.DAO;
import pettransport.dao.GenericDAO;
import pettransport.models.Pet;

/**
 *
 * @author masalas
 */
public class ControllerPetImpl implements ControllerPet{

    private DAO dao;
    
    public ControllerPetImpl(){
        this.dao = new GenericDAO();
    }
    
    @Override
    public void adicionarPet(Pet pet) throws Exception{
        this.dao.adicionarEntidade(pet);
    }
    
    @Override
    public void atualizarPet(Pet pet) throws Exception{
        this.dao.atualizarEntidade(pet);
    }

    @Override
    public void deletarPet(Pet pet) throws Exception{
        this.dao.deletarEntidade(pet);
       
    }

    @Override
    public Pet getPetById(int id) throws Exception{
       return (Pet) this.dao.findById(Pet.class, id);
    }
    
}
