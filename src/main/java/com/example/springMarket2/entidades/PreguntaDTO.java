package com.example.springMarket2.entidades;

import java.time.LocalDate;

public class PreguntaDTO {

	
	private Long idPregunta;
	
	private String textoPregunta;
	
	private LocalDate fechaPregunta;
	
	private Long idUsuario;
	
	private Long idProducto;

	public Long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}

	public void setTextoPregunta(String textoPregunta) {
		this.textoPregunta = textoPregunta;
	}

	public LocalDate getFechaPregunta() {
		return fechaPregunta;
	}

	public void setFechaPregunta(LocalDate fechaPregunta) {
		this.fechaPregunta = fechaPregunta;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public PreguntaDTO(Long idPregunta, String textoPregunta, LocalDate fechaPregunta, Long idUsuario,
			Long idProducto) {
		super();
		this.idPregunta = idPregunta;
		this.textoPregunta = textoPregunta;
		this.fechaPregunta = fechaPregunta;
		this.idUsuario = idUsuario;
		this.idProducto = idProducto;
	}
	
	
}
