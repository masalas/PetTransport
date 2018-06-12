/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.models;

import java.util.List;

/**
 *
 * @author masalas
 */
public class Cliente extends Pessoa{
    
    private List<Pet> pets;
    
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    
}
