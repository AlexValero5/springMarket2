package com.example.springMarket2.entidades;

public class ItemCarrito {
	
	private Long idProducto;
	
	private String nombreProducto;
	
	private Integer cantidad;
	
	private Float precio;

	public long getIdProducto() {
		return idProducto;
	}

	public ItemCarrito(Long idProducto, String nombreProducto,Float precio, Integer cantidad) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precio=precio;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	

}
