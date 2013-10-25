package com.fpmislata.daw2.banco.datos;

import com.fpmislata.daw2.banco.negocio.EntidadBancaria;
import com.fpmislata.daw2.banco.negocio.TipoEntidadBancaria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntidadBancariaDAO implements EntidadBancariaDAO2{

    ConnectionFactory connectionFactory = new ConnectionFactoryImpJDBC();
    
    @Override
    public EntidadBancaria read(Integer idEntidadBancaria) throws SQLException {

        Connection connection = connectionFactory.getConnection();

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

            if (resultSet.next() == true) {
                throw new RuntimeException("Hay otra fila igual");
            }
        } else {
            entidadBancaria = null;
        }

        connection.close();
        return entidadBancaria;

    }
    
    @Override
    public void insert(EntidadBancaria entidadBancaria) throws SQLException {

        Connection connection = connectionFactory.getConnection();

        String insertTableSQL = "INSERT INTO entidadbancaria (idEntidad, codigoEntidad, nombre, cif,tipoEntidadBancaria) VALUES (?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);

        preparedStatement.setInt(1, entidadBancaria.getIdEntidadBancaria());
        preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(3, entidadBancaria.getNombre());
        preparedStatement.setString(4, entidadBancaria.getCif());
        preparedStatement.setString(5, entidadBancaria.getTipoEntidadBancaria().name());

        preparedStatement.executeUpdate();
        connection.close();
    }
    @Override
    public void update(EntidadBancaria entidadBancaria) throws SQLException {

        Connection connection = connectionFactory.getConnection();

        String updateSQL = "UPDATE entidadbancaria SET codigoEntidad=?,nombre=?,cif=?,tipoEntidadBancaria=? WHERE idEntidad=?";

        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

        preparedStatement.setString(1, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(2, entidadBancaria.getNombre());
        preparedStatement.setString(3, entidadBancaria.getCif());
        preparedStatement.setString(4, entidadBancaria.getTipoEntidadBancaria().name());

        preparedStatement.executeUpdate();
        connection.close();
    }
    
    @Override
    public void delete(Integer idEntidadBancaria) throws SQLException {

        Connection connection = connectionFactory.getConnection();

        String deleteSQL = "DELETE FROM entidadbancaria WHERE idEntidad=?";

        PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);

        preparedStatement.setInt(1, idEntidadBancaria);

        preparedStatement.executeUpdate();
        connection.close();

    }
    
    @Override
    public List<EntidadBancaria> findAll() throws SQLException {

        Connection connection = connectionFactory.getConnection();

        List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
        String selectAllSQL = "SELECT * FROM entidadbancaria";

        PreparedStatement preparedStatement = connection.prepareStatement(selectAllSQL);
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

        connection.close();
        return entidadesBancarias;

    }
    
    /*@Override*/
    public List<EntidadBancaria> findByCodigo(String codigo) throws SQLException {
        
        /*String codigoEntidad = Integer.toString(codigo);*/

        Connection connection = connectionFactory.getConnection();

        List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
        String selectAllSQL = "SELECT * FROM entidadbancaria WHERE codigoEntidad=?";


        PreparedStatement preparedStatement = connection.prepareStatement(selectAllSQL);

        preparedStatement.setString(1, codigo);
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

        connection.close();
        return entidadesBancarias;
    }
}
