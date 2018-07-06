/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.controller;

import java.util.List;
import pettransport.models.Pet;

/**
 *
 * @author masalas
 */
public interface ControllerPet {
    
    public void adicionarPet(Pet pet);
    
    public void atualizarPet(Pet pet) throws Exception;
    
    public void deletarPet(Pet pet) throws Exception;
    
    public Pet getPetById(int id);
    
    public List<Pet> getTodosPets();
    
}

