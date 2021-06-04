package com.example.springMarket2.daos;

import com.example.springMarket2.entidades.Usuario;

public interface UsuarioDao extends DaoGenerico<Usuario> {
	
//	public boolean logIn(String nombreUsuario, String contraseña);
	
	public Usuario buscarPorNombreUsuario(String nombreUsuario);
	

}
