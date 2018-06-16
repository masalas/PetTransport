/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.dao;

import java.util.List;
/**
 *
 * @author masalas
 */
public interface DAO {
    public void adicionarEntidade(Object obj);
    
   public void deletarEntidade(Object obj);
   
   public void atualizarEntidade(Object obj);
   
   public Object findById(Class<?> clazz, int id);
   
    public List<Object> findAll(Class<?> clazz);
}
