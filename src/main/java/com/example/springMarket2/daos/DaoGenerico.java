package com.example.springMarket2.daos;

import java.util.Map;

public interface DaoGenerico<T> {

	
	long contarTodos(Map<String, Object> params);
	
	T crear(T t);
	
	
	
	T buscar(Object id);
	
	T actualizar(T t);

	void borrar(Object id);

}
