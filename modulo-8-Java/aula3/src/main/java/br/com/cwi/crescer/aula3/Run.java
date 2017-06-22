/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alana.weiss
 */
public class Run {

    public static void main(String[] args) {

        // Oracle Thin 
        // jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
        // oracle.jdbc.driver.OracleDriver
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "JAVA";
        final String pass = "JAVA";
        final String query = "SELECT * FROM CIDADE";
        
        try (final Connection connection = DriverManager.getConnection(url, user, pass);
             final Statement statement = connection.createStatement(); 
             final ResultSet resultSet = statement.executeQuery(query)) {
                    //..
             while(resultSet.next()){
                 System.out.println(resultSet.getString("NOME"));
             }
            
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }

    }
}
