
package com.fpmislata.daw2.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EntidadBancariaDAO {

    ConnectionFactory connectionFactory = new ConnectionFactoryImpJDBC();

    public EntidadBancariaDAO() throws SQLException {

    }

    public EntidadBancaria read(int idEntidadBancaria) throws SQLException {

        EntidadBancaria entidadBancaria;

        String selectSQL = "SELECT * FROM entidadBancaria WHERE idEntidad = ?";
        PreparedStatement preparedStatement = connectionFactory.conectar().prepareStatement(selectSQL);
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

        connectionFactory.desconectar();
        return entidadBancaria;

    }

    public void insert(EntidadBancaria entidadBancaria) throws SQLException {
        String insertTableSQL = "INSERT INTO entidadbancaria (idEntidad, codigoEntidad, nombre, cif,tipoEntidadBancaria) VALUES (?,?,?,?,?)";

        PreparedStatement preparedStatement = connectionFactory.conectar().prepareStatement(insertTableSQL);

        preparedStatement.setInt(1, entidadBancaria.getIdEntidadBancaria());
        preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(3, entidadBancaria.getNombre());
        preparedStatement.setString(4, entidadBancaria.getCif());
        preparedStatement.setString(5, entidadBancaria.getTipoEntidadBancaria().name());

        preparedStatement.executeUpdate();
        connectionFactory.desconectar();
    }

    public void update(EntidadBancaria entidadBancaria) throws SQLException {

        String updateSQL = "UPDATE entidadbancaria SET codigoEntidad=?,nombre=?,cif=?,tipoEntidadBancaria=?";

        PreparedStatement preparedStatement = connectionFactory.conectar().prepareStatement(updateSQL);

        preparedStatement.setString(1, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(2, entidadBancaria.getNombre());
        preparedStatement.setString(3, entidadBancaria.getCif());
        preparedStatement.setString(4, entidadBancaria.getTipoEntidadBancaria().name());

        preparedStatement.executeUpdate();
        connectionFactory.desconectar();
    }

    public void delete(int idEntidadBancaria) throws SQLException {
        
        String deleteSQL = "DELETE FROM entidadbancaria WHERE idEntidad=?";
        
        PreparedStatement preparedStatement = connectionFactory.conectar().prepareStatement(deleteSQL);
        
        preparedStatement.setInt(1, idEntidadBancaria);
        
        preparedStatement.executeUpdate();
        connectionFactory.desconectar();
        
    }

    public List<EntidadBancaria> findAll() throws SQLException {
        
        
        List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
        String selectAllSQL = "SELECT * FROM entidadbancaria";
        
        PreparedStatement preparedStatement = connectionFactory.conectar().prepareStatement(selectAllSQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next() == true) {
            EntidadBancaria entidadBancaria = new EntidadBancaria();
            
            entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidad"));
            entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
            entidadBancaria.setNombre(resultSet.getString("nombre"));
            entidadBancaria.setCif(resultSet.getString("cif"));
            entidadBancaria.setTipoEntidadBancaria(TipoEntidadBancaria.valueOf(resultSet.getString("tipoEntidadBancaria")));

            entidadesBancarias.add(entidadBancaria);
        }
        
        connectionFactory.desconectar();
        return entidadesBancarias;

    }

    public List<EntidadBancaria> findByCodigo(String codigo) throws SQLException {
                
        List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
        String selectAllSQL = "SELECT * FROM entidadbancaria WHERE codigoEntidad=?";
        
        
        PreparedStatement preparedStatement = connectionFactory.conectar().prepareStatement(selectAllSQL);
        
        preparedStatement.setString(1,codigo);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next() == true) {
            EntidadBancaria entidadBancaria = new EntidadBancaria();
            
            entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidad"));
            entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
            entidadBancaria.setNombre(resultSet.getString("nombre"));
            entidadBancaria.setCif(resultSet.getString("cif"));
            entidadBancaria.setTipoEntidadBancaria(TipoEntidadBancaria.valueOf(resultSet.getString("tipoEntidadBancaria")));

            entidadesBancarias.add(entidadBancaria);
        }
        
        connectionFactory.desconectar();
        return entidadesBancarias;
    }
}
