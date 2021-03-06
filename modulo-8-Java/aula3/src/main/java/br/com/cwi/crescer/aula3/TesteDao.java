/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

/**
 *
 * @author alana.weiss
 */
public class TesteDao {
    
    private static final String DROP_TABLE = "DROP TABLE TESTE";

    private static final String CREATE_TABLE = "CREATE TABLE TESTE ( \n"
            + "  ID NUMBER(8) NOT NULL,\n"
            + "  NOME VARCHAR2(60) DEFAULT NULL, \n"
            + "  CONSTRAINT TESTE_PK PRIMARY KEY (ID)  ENABLE \n"
            + ")";

    private static final String INSERT_TESTE = " INSERT INTO TESTE (ID, NOME) VALUES (?,?)";

    /**Método criar a tabela d=no banco
    */
     public static final void create(){
        try (final Statement statement = ConectionUtils.getConnection().createStatement()) {
                statement.executeQuery(CREATE_TABLE);
            } catch (SQLException e) {
                System.err.format("SQLException: %s", e);
            }
    }
     
    /**Método dropar a tabela do banco
    */
    public static final void drop(){
        try (final Statement statement = ConectionUtils.getConnection().createStatement()) {
                statement.executeQuery(DROP_TABLE);
            } catch (SQLException e) {
                System.err.format("SQLException: %s", e);
            }
    }
    
    /**Método para inserir dados na tabela
    */
    public static final void insert(){
        
            try (final PreparedStatement preparedStatement = ConectionUtils.getConnection().prepareStatement(INSERT_TESTE)) {
                final List<Long> list = LongStream.range(1, 1000).boxed().collect(toList());
                
                for (Long id : list) {
                    preparedStatement.setLong(1, id);
                    preparedStatement.setString(2, String.format("%s pessoa de 999", id));
                    preparedStatement.executeUpdate();
                }
                
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
    }
}
