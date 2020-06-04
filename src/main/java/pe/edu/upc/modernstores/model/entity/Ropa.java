package pe.edu.upc.modernstores.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "ropas")
public class Ropa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Positive(message = "El precio debe ser mayor a cero")
	@Column(name = "precio", nullable = false)
	private double precio;
	
	@Min(value = 1)
	@Max(value = 50)
	@Column(name = "stock", nullable = false)
	private int stock;
	
	@NotEmpty(message = "La lista no puede estar vacia")
	@OneToMany(mappedBy = "ropa", fetch = FetchType.LAZY)
	private List<Calificacion> listaCalificaciones;
	
	@NotEmpty(message = "La lista no puede estar vacia")
	@OneToMany(mappedBy = "ropa", fetch = FetchType.LAZY)
	private List<Detalle> listaDetalles;
	
	@NotNull(message = "Por favor especifique la categoria")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@NotEmpty(message = "Por favor especifique el Comerciante")
	@ManyToMany(mappedBy = "listaRopas")
	private List<Comerciante> listaComerciantes;
	
	@NotNull(message = "Por favor especifique el carrito")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrito_id")
	private Carrito carrito;
	
	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Ropa() {
		listaCalificaciones = new ArrayList<Calificacion>();
		listaDetalles = new ArrayList<Detalle>();
		listaComerciantes = new ArrayList<Comerciante>();
	}
	
	public void addCalificacion(Calificacion calificacion) {
		listaCalificaciones.add(calificacion);
	}
	
	public void addDetalle(Detalle detalle) {
		listaDetalles.add(detalle);
	}
	
	public void addComerciante(Comerciante comerciante) {
		listaComerciantes.add(comerciante);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Calificacion> getListaCalificaciones() {
		return listaCalificaciones;
	}

	public void setListaCalificaciones(List<Calificacion> listaCalificaciones) {
		this.listaCalificaciones = listaCalificaciones;
	}

	public List<Detalle> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<Detalle> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Comerciante> getListaComerciantes() {
		return listaComerciantes;
	}

	public void setListaComerciantes(List<Comerciante> listaComerciantes) {
		this.listaComerciantes = listaComerciantes;
	}
}
