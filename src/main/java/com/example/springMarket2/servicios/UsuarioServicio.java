package com.example.springMarket2.servicios;

import com.example.springMarket2.entidades.Usuario;

public interface UsuarioServicio {
	
//	public boolean logIn(String nombreUsuario, String contraseña);
	
	public Usuario crearUsuario(Usuario usuario);
	
	public void eliminarUsuario(long idUsuario);
	
	public Usuario obtenerUsuario(long idUsuario);
	
	public Usuario modificarUsuario(Usuario usuario);
	
	public Usuario buscarUsuario(String nombreUsuario);

}
