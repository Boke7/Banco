package com.fpmislata.daw2.banco.datos;

import java.util.List;


public interface GenericDAO<T,ID> {
    
    T read(ID id);
    void insert(T t);
    void update(T t);
    void delete(ID id);   
    List<T> findAll();
    List<T> findByCodigo(ID id);
    
}
