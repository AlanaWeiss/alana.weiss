/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alana.weiss
 */
public final class ConectionUtils {
    
        
    public static Connection getConnection() throws SQLException{
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "JAVA";
        final String pass = "JAVA";

       return DriverManager.getConnection(url, user, pass);
    }
    
}
