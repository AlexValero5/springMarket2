package com.example.springMarket2.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROL")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL")
	private Long idRol;

	@Column(name = "NOMBRE_ROL")
	private String nombreRol;
	
	@ManyToMany(mappedBy="roles",fetch = FetchType.EAGER)
	private Set<Usuario> usuarios;

	

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuario) {
		usuarios = usuario;
	}
	
	public void anadirUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		usuario.getRoles().add(this);
	}
	
	public void deleteUsuario(Usuario usuario) {
		this.usuarios.remove(usuario) ;
	}

}
