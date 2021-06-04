package com.example.springMarket2.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springMarket2.daos.RolRepository;
import com.example.springMarket2.daos.UsuarioDao;
import com.example.springMarket2.entidades.Rol;
import com.example.springMarket2.entidades.Usuario;


@Transactional
@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	
	@Autowired
	private UsuarioDao usuarioDao;
	

	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


//	@Override
//	public boolean logIn(String nombreUsuario, String contraseña) {
//		
//		return usuarioDao.logIn(nombreUsuario, contraseña);
//	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		usuario.setContraseña(bCryptPasswordEncoder.encode(usuario.getContraseña()));
		Rol r = rolRepository.findById(1L).orElse(null);
		usuario.anadirRol(r);
		return usuarioDao.crear(usuario);
	}

	@Override
	public void eliminarUsuario(long idUsuario) {
		usuarioDao.borrar(idUsuario);
		
	}

	@Override
	public Usuario obtenerUsuario(long idUsuario) {
		return usuarioDao.buscar(idUsuario);
	}

	@Override
	public Usuario modificarUsuario(Usuario usuario) {
		usuarioDao.actualizar(usuario);
		return null;
	}

	@Override
	public Usuario buscarUsuario(String nombreUsuario) {
		return usuarioDao.buscarPorNombreUsuario(nombreUsuario);
	}

}
