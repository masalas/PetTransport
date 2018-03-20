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
    
    public void addPet(Pet pet);
    
    public void removePet(Pet pet);
    
    public Pet getPetById(int id);
    
    public List<Pet> getPetsByUserId(int user_id);
    
}

