package com.example.springMarket2.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "COMPRA")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPRA")
	private Long idCompra;

//	@ManyToOne
//	@JoinColumn(name = "ID_USUARIO")
//	private Usuario usuario;
//	
//	
//	@OneToMany(
//	mappedBy = "compra",
//	cascade = CascadeType.ALL,
//	orphanRemoval = true)
//	private List<ProductoCompra> productos = new ArrayList<>();
	
	
	//https://stackoverflow.com/questions/5478328/in-which-case-do-you-use-the-jpa-jointable-annotation
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@Column(name="PRECIO")
	private Float precio;

	
    //https://stackoverflow.com/questions/26437501/hibernate-inverse-join-for-composite-primary-key
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "PRODUCTO_COMPRA", joinColumns = @JoinColumn(name = "ID_COMPRA"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUCTO"))
	private Set<Producto> productos = new HashSet<>();
	
	
	//private Date fecha;
	
	
	
	public Long getIdCompra() {
		return idCompra;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}
	
	
		
	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public boolean anadirProducto(Producto producto) {
        producto.getCompras().add(this);
        if (getPrecio() == null)
            setPrecio(0F);
        setPrecio(getPrecio() + producto.getPrecioProducto() * producto.getCantidadProducto());
        return getProductos().add(producto);
    }

	public void eliminarProducto(Producto producto) {
		this.productos.remove(producto);
		producto.getCompras().remove(this);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	
}
