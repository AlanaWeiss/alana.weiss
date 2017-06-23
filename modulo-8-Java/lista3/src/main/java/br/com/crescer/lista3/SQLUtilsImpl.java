/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista3;

import java.beans.Statement;
import java.io.File;
import br.com.crescer.lista2.ReaderUtilsImp;
import br.com.crescer.lista2.WriterUtilsImpl;
import br.com.cwi.crescer.aula3.ConectionUtils;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author alana'
 */
public class SQLUtilsImpl implements SQLUtils{

    @Override
    public void runFile(String filename) {
        if(!filename.endsWith(".sql")) return;
        try (final java.sql.Statement statement = ConectionUtils.getConnection().createStatement()) {
            final String queries = new ReaderUtilsImp().read(filename);
            for(String query : queries.split(";")) {
                statement.addBatch(query);
            }
            statement.executeBatch();
        } catch (Exception e) {
            
        }
    }

    @Override
    public String executeQuery(String query) {
        try (final java.sql.Statement statement = ConectionUtils.getConnection().createStatement();
                final ResultSet resultSet = statement.executeQuery(query);) {
            return gerarCSV(resultSet);
        } catch (SQLException ex) {
            throw new RuntimeException("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public void importCSV(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File exportCSV(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String gerarCSV(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int quantColunas = rsmd.getColumnCount();
        if(quantColunas == 0)
            return "";
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i <= quantColunas; i++) {
            builder.append(rsmd.getColumnLabel(i)).append(",");
        }
        builder.deleteCharAt(builder.lastIndexOf(",")).append("\n");
        while(resultSet.next()) {
            for(int i = 1; i <= quantColunas; i++) {
                builder.append(resultSet.getString(i)).append(",");
            }
            builder.deleteCharAt(builder.lastIndexOf(",")).append("\n");
        }
        return builder.toString();
    }
    
}
