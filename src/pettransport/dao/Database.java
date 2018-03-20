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
import java.sql.Statement;

/**
 *
 * @author masalas
 */
public class Database {
    
    private final String HOST="localhost";
    private final String DATABASE="PetTransport";
    private final String PORT="5432";
    private final String USER="postgres";
    private final String PASSWORD = "123";
    
    
    private Connection c;
    private Statement stmt;

    public Database() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
            String url = format("jdbc:postgresql://%s:%s/%s",HOST,PORT,DATABASE);
            this.c = DriverManager.getConnection(url, USER, PASSWORD);
            this.c.setAutoCommit(false) ;

        } catch (ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
    }
    
    private void criaTabelas(){
        
    }
    
    public void close() throws SQLException{
        this.c.close();
    }       
    
}
