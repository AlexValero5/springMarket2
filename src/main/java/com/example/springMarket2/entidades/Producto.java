package com.example.springMarket2.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTO")
public class Producto implements Serializable {

private static final long serialVersionUID = 1L;


@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="ID_PRODUCTO")
private Long idProducto;


@Column(name="NOMBRE")
private String nombreProducto;

@Column(name="DESCRIPCION")
private String descripcionProducto;

@Column(name="PRECIO")
private Long precioProducto;

@Column(name="DESCUENTO")
private Long descuentoProducto;

public Long getIdProducto() {
	return idProducto;
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

public String getDescripcionProducto() {
	return descripcionProducto;
}

public void setDescripcionProducto(String descripcionProducto) {
	this.descripcionProducto = descripcionProducto;
}

public Long getPrecioProducto() {
	return precioProducto;
}

public void setPrecioProducto(Long precioProducto) {
	this.precioProducto = precioProducto;
}

public Long getDescuentoProducto() {
	return descuentoProducto;
}

public void setDescuentoProducto(Long descuentoProducto) {
	this.descuentoProducto = descuentoProducto;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

}
