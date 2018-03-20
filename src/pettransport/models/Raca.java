/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.models;

/**
 *
 * @author masalas
 */
public class Raca {
    
    private int id;
    private String nome;
    private Porte porte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }
    
    
            
   public enum Porte{
       PEQUENO,
       MEDIO,
       GRANDE
   }
    
}
