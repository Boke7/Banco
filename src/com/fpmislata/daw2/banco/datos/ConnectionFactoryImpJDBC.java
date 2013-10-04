
package com.fpmislata.daw2.banco.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactoryImpJDBC implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No esta instalado el Driver JDBC");
            e.printStackTrace();
        }

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/Banco", "root", "root");

        } catch (SQLException e) {
            System.out.println("Conexión fallida.");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Conexión realizada");
        } else {
            System.out.println("Fallo al realizar la conexión");
        }
        
        return connection;
    }

}
