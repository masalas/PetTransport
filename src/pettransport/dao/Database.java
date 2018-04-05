/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.String.format;
import java.sql.Connection;

/**
 * DAO de database
 * @author masalas
 */
public class Database {
    
    private static final String HOST="localhost";
    private static final String DATABASE="PetTransport";
    private static final String PORT="5432";
    private static final String USER="postgres";
    private static final String PASSWORD = "123";
    
    
    private static Connection c;

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(Database.c==null){
            Class.forName("org.postgresql.Driver");
            String url = format("jdbc:postgresql://%s:%s/%s",Database.HOST, Database.PORT, Database.DATABASE);
            Database.c = DriverManager.getConnection(url, Database.USER, Database.PASSWORD);
            Database.c.setAutoCommit(false) ;
        }
        return Database.c;
    }
    
    private void criaTabelas(){
        
    }
    
    public void close() throws SQLException{
        this.c.close();
    }       
    
}
