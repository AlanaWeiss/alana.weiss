/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author alana.weiss
 */
public class DDL {

    
    public static void main(String[] args) {

        try (final Connection connection = ConectionUtils.getConnection()) {

            TesteDao.drop();
            TesteDao.create();
            TesteDao.insert();

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
