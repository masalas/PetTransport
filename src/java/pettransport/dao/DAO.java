/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author masalas
 */
public class DAO {
    private static final String DATABASE="Pettransport";
    private static EntityManager entityManager;
    
   public DAO(){
       if (entityManager == null){
           /*EntityManagerFactory factory = Persistence.createEntityManagerFactory(DATABASE);
           this.entityManager = factory.createEntityManager();
           this.entityManager.getTransaction().begin();*/
       }
   }
   
   public void adicionarEntidade(Object obj){
       this.entityManager.persist(obj);
       this.entityManager.getTransaction().commit();   
   }
    
   public void deletarEntidade(Object obj){
       this.entityManager.remove(obj);
       this.entityManager.getTransaction().commit();
   }
   
   public void atualizarEntidade(Object obj){
       this.entityManager.refresh(obj);
       this.entityManager.getTransaction().commit();
   }
   public Object findById(Class<?> clazz, int id){
       Query q = this.entityManager.createQuery(
               String.format("SELECT e FROM %s e WHERE id=%d", clazz.getName(), id));
       return q.getSingleResult();
   }
   
    public List<Object> findAll(Class<?> clazz){
       Query q = this.entityManager.createQuery(
               String.format("SELECT e FROM %s e", clazz.getName()));
       return q.getResultList();
   }
}
