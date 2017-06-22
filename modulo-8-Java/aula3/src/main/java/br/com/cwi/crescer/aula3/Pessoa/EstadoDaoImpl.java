/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alana.weiss
 */
public class EstadoDaoImpl implements EstadoDao{
    private static final String INSERT_ESTADO = "INSERT INTO ESTADO  (ID, NOME, UF, PAIS) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_ESTADO = "UPDATE ESTADO  SET NOME = ?, UF = ? WHERE ID =?";
    private static final String DELETE_ESTADO = "DELETE FROM ESTADO  WHERE ID =?";
    private static final String LOAD_ESTADO = "SELECT * FROM ESTADO  WHERE ID = ?";

    @Override
    public void insert(Estado estado) {
        try (final PreparedStatement preparedStatement
                = ConectionUtils.getConnection().prepareStatement(INSERT_ESTADO)) {

            preparedStatement.setLong(1, estado.getId());
            preparedStatement.setString(2, estado.getNome());
            preparedStatement.setString(3, estado.getUf());
            preparedStatement.setLong(4, estado.getPais());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Estado estado) {
        try (final PreparedStatement preparedStatement
                = ConectionUtils.getConnection().prepareStatement(UPDATE_ESTADO)) {
            preparedStatement.setString(1, estado.getNome());
            preparedStatement.setString(2, estado.getUf());
            preparedStatement.setLong(3, estado.getPais());
            preparedStatement.setLong(3, estado.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Estado estado) {
        try (final PreparedStatement preparedStatement
                = ConectionUtils.getConnection().prepareStatement(DELETE_ESTADO)) {
            preparedStatement.setLong(1, estado.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Estado loadBy(Long id) {
        final Estado estado = new Estado();
        try (final PreparedStatement preparedStatement
                = ConectionUtils.getConnection().prepareStatement(LOAD_ESTADO)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    estado.setId(resultSet.getLong("ID"));
                    estado.setNome(resultSet.getString("NOME"));
                    estado.setUf(resultSet.getString("UF"));
                    estado.setPais(resultSet.getLong("PAIS"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return estado;
    }
    
}
