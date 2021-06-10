package com.example.springMarket2.entidades;

import java.time.LocalDate;

public class RespuestaDTO {
	
	private Long idRespuesta;
	
	private String textoRespuesta;
	
	private LocalDate fechaRespuesta;
	
	private Long idPregunta;
	
	private Long idUsuario;
	
	private String nombreUsuario;
	
	

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public Long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public RespuestaDTO(Long idRespuesta, String textoRespuesta, LocalDate fechaRespuesta, Long idPregunta,
			String nombreUsuario, Long idUsuario) {
		super();
		this.idRespuesta = idRespuesta;
		this.textoRespuesta = textoRespuesta;
		this.fechaRespuesta = fechaRespuesta;
		this.idPregunta = idPregunta;
		this.nombreUsuario = nombreUsuario;
		this.idUsuario=idUsuario;
	}
	
	

}
