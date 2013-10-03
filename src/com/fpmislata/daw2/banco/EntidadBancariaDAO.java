/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAO {

    Connection connection = null;

    public EntidadBancariaDAO() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No esta instalado el Driver JDBC");
            e.printStackTrace();
            return;
        }
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/Banco", "root", "root");

        } catch (SQLException e) {
            System.out.println("Conexión fallida.");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("Conexión realizada");
        } else {
            System.out.println("Fallo al realizar la conexión");
        }
    }

    public EntidadBancaria read(int idEntidadBancaria) throws SQLException {
        
        EntidadBancaria entidadBancaria;

        String selectSQL = "SELECT * FROM entidadBancaria WHERE idEntidad = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, idEntidadBancaria);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next() == true) {
            entidadBancaria = new EntidadBancaria();
            entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidad"));
            entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
            entidadBancaria.setNombre(resultSet.getString("nombre"));
            entidadBancaria.setCif(resultSet.getString("cif"));
            entidadBancaria.setTipoEntidadBancaria(TipoEntidadBancaria.valueOf(resultSet.getString("tipoEntidadBancaria")));

            System.out.println(entidadBancaria.getIdEntidadBancaria() + " " + entidadBancaria.getCodigoEntidad() + " " + entidadBancaria.getNombre() + " " + entidadBancaria.getCif() + " " + entidadBancaria.getTipoEntidadBancaria());

            if (resultSet.next() == true) {
                throw new RuntimeException("Hay otra fila igual");
            }
        } else {
            entidadBancaria = null;
        }

        return entidadBancaria;

    }

    public void insertEntidadBancaria(EntidadBancaria entidadBancaria) throws SQLException {
        String insertTableSQL = "INSERT INTO entidadbancaria (idEntidad, codigoEntidad, nombre, cif,tipoEntidadBancaria) VALUES (?,?,?,?,?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
        
        preparedStatement.setInt(1, entidadBancaria.getIdEntidadBancaria());
        preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(3, entidadBancaria.getNombre());
        preparedStatement.setString(4, entidadBancaria.getCif());
        preparedStatement.setString(5, entidadBancaria.getTipoEntidadBancaria().name());

        preparedStatement.executeUpdate();
    }

    public void updateEntidadBancaria(EntidadBancaria entidadBancaria) throws SQLException {
    }

    public void deleteEntidadBancaria(int idEntidadBancaria) {
    }

    public List<EntidadBancaria> findAll() {
        return null;

    }

    public List<EntidadBancaria> findByCodigo(String codigo) {
        return null;

    }
}
