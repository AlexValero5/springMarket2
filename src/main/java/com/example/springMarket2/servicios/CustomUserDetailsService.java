package com.example.springMarket2.servicios;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springMarket2.daos.UsuarioDao;
import com.example.springMarket2.entidades.Rol;
import com.example.springMarket2.entidades.Usuario;
@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional()
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.buscarPorNombreUsuario(nombre);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Rol rol : usuario.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
		}

		return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getContraseña(),
				grantedAuthorities);
	}

}
