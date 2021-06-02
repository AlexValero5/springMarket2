package com.example.springMarket2.daos;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springMarket2.entidades.Usuario;

@Repository
@Component("UsuarioDao")
public class UsuarioDaoImpl extends DaoGenericoImpl<Usuario> implements UsuarioDao{

	@Override
	public boolean logIn(String nombreUsuario, String contraseña) {
		Usuario user = buscarPorNombreUsuario(nombreUsuario);
		if(user==null)
			return false;
		else if(!user.getContraseña().equals(contraseña))
			return false;
		else
			return true;
	}

	@Override
	public Usuario buscarPorNombreUsuario(String nombreUsuario) {
		Usuario user = new Usuario();
		
		Query query = this.em.createQuery("FROM Usuario u where u.username= :username");
		query.setParameter("username", nombreUsuario);
		user = (Usuario) query.getSingleResult();
		
		if (user != null) {
			return user;
		}
		return null;
	}

}
