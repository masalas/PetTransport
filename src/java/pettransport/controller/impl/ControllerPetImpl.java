/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.controller.impl;

import pettransport.controller.ControllerPet;
import pettransport.dao.PetDAO;
import pettransport.models.Pet;

/**
 *
 * @author masalas
 */
public class ControllerPetImpl implements ControllerPet{

    public PetDAO dao;
    
    public ControllerPetImpl(){
        dao = new PetDAO();
    }
    
    @Override
    public void adicionarPet(Pet pet) throws Exception{
        this.dao.adicionarPet(pet);
    }
    
    @Override
    public void atualizarPet(Pet pet) throws Exception{
        this.dao.atualizarPet(pet);
    }

    @Override
    public void deletarPet(Pet pet) throws Exception{
        this.dao.deletarPet(pet);
       
    }

    @Override
    public Pet getPetById(int id) throws Exception{
       return this.dao.getPetById(id);
    }
    
}
