package com.example.springMarket2.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
private Float precioProducto;

@Column(name="DESCUENTO")
private Integer descuentoProducto;

@Column(name="CANTIDAD")
private Integer cantidadProducto;

@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
private Set<Pregunta> preguntas = new HashSet<>();

//@OneToMany(
//		mappedBy = "producto",
//		cascade = CascadeType.ALL,
//		orphanRemoval = true
//		)
//private List<ProductoCompra> compras = new ArrayList<>();

public Integer getCantidadProducto() {
	return cantidadProducto;
}

public void setCantidadProducto(Integer cantidadProducto) {
	this.cantidadProducto = cantidadProducto;
}


@ManyToMany(mappedBy = "productos")
private Set<Compra> compras = new HashSet<>();

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

public Float getPrecioProducto() {
	return precioProducto;
}

public void setPrecioProducto(Float precioProducto) {
	this.precioProducto = precioProducto;
}

public Integer getDescuentoProducto() {
	return descuentoProducto;
}

public void setDescuentoProducto(Integer descuento) {
	this.descuentoProducto = descuento;
}

public Set<Compra> getCompras() {
	return compras;
}

public void setCompras(Set<Compra> compras) {
	this.compras = compras;
}

public void anadirCompra(Compra c) {
	this.compras.add(c);

}


public static long getSerialversionuid() {
	return serialVersionUID;
}

public Set<Pregunta> getPreguntas() {
	return preguntas;
}

public void setPreguntas(Set<Pregunta> preguntas) {
	this.preguntas = preguntas;
}


}
