
package com.fpmislata.daw2.banco;

import java.sql.Connection;


public interface ConnectionFactory {
    
    public Connection conectar();
    
    public void desconectar();
    
}
