package com.example.springMarket2.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESPUESTA")
public class Respuesta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESPUESTA")
	private Long idRespuesta;
	
	@Column(name="TEXTO")
	private String textoRespuesta;
	
	@Column(name="FECHA")
	private LocalDate fechaRespuesta;
	
	@ManyToOne
	@JoinColumn(name = "ID_PREGUNTA")
	private Pregunta pregunta;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	public Respuesta() {}
	public Respuesta(String textoRespuesta,LocalDate fechaRespuesta,Pregunta pregunta,Usuario usuario) {
		
		this.textoRespuesta=textoRespuesta;
		this.fechaRespuesta=fechaRespuesta;
		this.pregunta=pregunta;
		this.usuario=usuario;
	}

	public Long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getTextoRespuesta() {
		return textoRespuesta;
	}

	public void setTextoRespuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}

	public LocalDate getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(LocalDate fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
