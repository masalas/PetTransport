/*
 * To change GenericDAO license header, choose License Headers in Project Properties.
 * To change GenericDAO template file, choose Tools | Templates
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
public class GenericDAO implements DAO{
    private static final String DATABASE="Pettransport";
    private static EntityManager entityManager;
    
   public GenericDAO(){
       if (entityManager == null){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory(DATABASE);
           GenericDAO.entityManager = factory.createEntityManager();
       }
   }
   
   @Override
   public void adicionarEntidade(Object obj){
       GenericDAO.entityManager.getTransaction().begin();
       GenericDAO.entityManager.persist(obj);
       GenericDAO.entityManager.getTransaction().commit();   
   }
   
   @Override
   public void deletarEntidade(Object obj){
       GenericDAO.entityManager.getTransaction().begin();
       GenericDAO.entityManager.remove(obj);
       GenericDAO.entityManager.getTransaction().commit();
   }
   
   @Override
   public void atualizarEntidade(Object obj){
       GenericDAO.entityManager.getTransaction().begin();
       GenericDAO.entityManager.merge(obj);
       GenericDAO.entityManager.getTransaction().commit();
   }
   
   @Override
   public Object findById(Class<?> clazz, int id){
       Query q = GenericDAO.entityManager.createQuery(
               String.format("SELECT e FROM %s e WHERE id=%d", clazz.getName(), id));
       return q.getSingleResult();
   }
   
   @Override
    public List<Object> findAll(Class<?> clazz){
       Query q = GenericDAO.entityManager.createQuery(
               String.format("SELECT e FROM %s e", clazz.getName()));
       return q.getResultList();
    }
}
