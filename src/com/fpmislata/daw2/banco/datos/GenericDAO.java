package com.fpmislata.daw2.banco.datos;

import java.sql.SQLException;
import java.util.List;


public interface GenericDAO<T,ID> {
    
    T read(ID id) throws SQLException;
    void insert(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(ID id) throws SQLException;   
    List<T> findAll() throws SQLException;
    List<T> findByCodigo(ID id) throws SQLException;
    
}
