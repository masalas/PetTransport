/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pettransport.models.Pet;

/**
 *
 * @author masalas
 */
public class PetDAO{
    
    private Statement stmt;
    
    public void adicionarPet(Pet pet) throws Exception{
        Statement stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append("INSERT INTO pet (nome, raca, observacoes, idade, user_id) ");
        str.append(String.format("VALUES (\'%s\', \'%s\', \'%s\', %d, %d );",
                pet.getNome(), pet.getRaca(), pet.getObservacoes(), pet.getIdade(), pet.getUser_id()));
        stmt.executeUpdate(str.toString());
        stmt.close();
        
    }
    
    public void atualizarPet(Pet pet) throws Exception{
        
        Statement stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append(String.format("UPDATE pet SET nome=\'%s\', raca=\'%s\', obervacoes=\'%s\', idade=%d, user_id=%d ",
            pet.getNome(), pet.getRaca(), pet.getObservacoes(), pet.getIdade(), pet.getUser_id()));
        str.append(String.format("WHERE id = %d ",pet.getId()));
        stmt.executeUpdate(str.toString());
        stmt.close();
        
    }
    
    public void deletarPet(Pet pet) throws Exception{
        
        Statement stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append("DELETE FROM pet ");
        str.append(String.format("WHERE id = %d;",pet.getId()));
        stmt.executeUpdate(str.toString());
        stmt.close();
        
    }
    
    public Pet getPetById(int id) throws Exception{
        Pet pet=null;
        
        stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append("SELECT id, nome, observacoes, idade, raca, user_id ");
        str.append("FROM pet ");
        str.append(String.format("WHERE id=%d;",id));
        
        
        ResultSet rs = stmt.executeQuery(str.toString()) ;
        
        while (rs.first()) {
            pet = new Pet();
            pet.setId(rs.getInt("id"));
            pet.setNome(rs.getString("nome"));
            pet.setIdade(rs.getInt("idade"));
            pet.setRaca(rs.getString("raca"));
            pet.setUser_id(rs.getInt("user_id"));
            
            pet.setObservacoes(rs.getString("observacoes"));
        }
        stmt.close();
        
        return pet;
    }
    
    
}
