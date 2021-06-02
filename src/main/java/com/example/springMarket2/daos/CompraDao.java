package com.example.springMarket2.daos;

import java.util.List;

import com.example.springMarket2.entidades.Compra;
import com.example.springMarket2.entidades.Usuario;

public interface CompraDao extends DaoGenerico<Compra> {

public List<Compra> listar();
	
	//public List<Compra> buscarPorUsuario (Usuario usuario);

	
	
}
