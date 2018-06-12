/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import pettransport.models.Endereco;

/**
 *
 * @author masalas
 */
public class EnderecoDAO {
     
    private Statement stmt;
    
    public void adicionarEndereco(Endereco endereco) throws Exception{
        Statement stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append("INSERT INTO endereco (rua, numero, complemento, bairro, cep, "
                + "ponto_referencia, cidade, estado ) ");
        str.append(String.format("VALUES (\'%s\', \'%s\', \'%s\', \'%s\', \'%s\',"
                + " \'%s\', \'%s\', \'%s\' ;",
                endereco.getRua(), endereco.getNumero(), endereco.getComplemento(),
                endereco.getBairro(), endereco.getCep(), endereco.getPonto_referencia(),
                endereco.getCidade(), endereco.getEstado()));                
        stmt.executeUpdate(str.toString());
        stmt.close();
        
    }
    
    public void atualizarEndereco(Endereco endereco) throws Exception{
        
        Statement stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append(String.format("UPDATE endereco SET rua=\'%s\', numero=\'%s\',"
                + " complemento=\'%s\', bairro=\'%s\',cep=\'%s\',"
                + " ponto_referencia=\'%s\', cidade=\'%s\', estado=\'%s\' ",
            endereco.getRua(), endereco.getNumero(), endereco.getComplemento(), 
            endereco.getBairro(),endereco.getCep(), endereco.getPonto_referencia(), 
            endereco.getCidade(), endereco.getEstado() ));
        str.append(String.format("WHERE id = %d ",endereco.getId()));
        stmt.executeUpdate(str.toString());
        stmt.close();
        
    }
    
    public void deletarEndereco(Endereco endereco) throws Exception{
        
        Statement stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append("DELETE FROM endereco ");
        str.append(String.format("WHERE id = %d;",endereco.getId()));
        stmt.executeUpdate(str.toString());
        stmt.close();
        
    }
    
    public Endereco getEnderecoById(int id) throws Exception{
        Endereco endereco=null;
        
        stmt = Database.getConnection().createStatement();
        
        StringBuilder str = new StringBuilder();
        str.append("SELECT id, rua, numero, complemento, bairro, "
                + "cep, ponto_referencia, cidade, estado ");
        str.append("FROM endereco ");
        str.append(String.format("WHERE id=%d;",id));
        
        
        ResultSet rs = stmt.executeQuery(str.toString()) ;
        
        while (rs.first()) {
            endereco = new Endereco();
            endereco.setId(rs.getInt("id"));
            endereco.setRua(rs.getString("rua"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCep(rs.getString("cep"));
            endereco.setPonto_referencia(rs.getString("ponto_referencia"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("estado"));
            
            
        }
        stmt.close();
        
        return endereco;
    }
    
    
    
    
    
    
}
