/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import pettransport.models.Pessoa;

/**
 *
 * @author masalas
 */
public class PessoaDAO {
    
    private Statement stmt;
    
    public void adicionarPessoa(Pessoa pessoa) throws Exception{
        Statement stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append("INSERT INTO pessoa (nome, telefone) ");
        str.append(String.format("VALUES (\'%s\', \'%s\');", pessoa.getNome(), pessoa.getTelefone()));
        
        stmt.executeUpdate(str.toString());
        stmt.close();
        
    }
    
    public void atualizarPessoa(Pessoa pessoa) throws Exception{
        
        Statement stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append(String.format("UPDATE pessoa SET nome=\'%s\', telefone=\'%s\' ",
            pessoa.getNome(), pessoa.getTelefone()));
        str.append(String.format("WHERE id = %d ",pessoa.getId()));
        stmt.executeUpdate(str.toString());
        stmt.close();
        
    }
    
    public void deletarPessoa(Pessoa pessoa) throws Exception{
        
        Statement stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append("DELETE FROM pessoa ");
        str.append(String.format("WHERE id = %d;",pessoa.getId()));
        stmt.executeUpdate(str.toString());
        stmt.close();
        
    }
    
    public Pessoa getPessoaById(int id) throws Exception{
        Pessoa pessoa=null;
        
        stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append("SELECT id, nome, telefone ");
        str.append("FROM pet ");
        str.append(String.format("WHERE id=%d;",id));
        
        
        ResultSet rs = stmt.executeQuery(str.toString()) ;
        
        while (rs.first()) {
            pessoa = new Pessoa();
            pessoa.setId(rs.getInt("id"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setTelefone(rs.getString("telefone"));
            
        }
        stmt.close();
        
        return pessoa;
    }
    
    
    
}
