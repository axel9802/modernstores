package pe.edu.upc.modernstores.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "carritos")
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Min(value = 1)
	@Max(value = 50)
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	
	@Min(value = 1)
	@Max(value = 200)
	@Column(name = "total", nullable = false)
	private int total;
	
	/*@NotEmpty(message = "La lista de ropas no puede estar vacia")
	@OneToMany(mappedBy = "carrito", fetch = FetchType.LAZY)
	private List<Ropa> listaRopas;*/
	
	/*@NotEmpty(message = "Por favor especifique la ropa")
	@ManyToMany(mappedBy = "listaCarritos")
	private List<Ropa> listaRopas;*/
	
	@OneToOne(mappedBy = "carrito")
	private Cliente cliente;
	
	@NotEmpty(message = "La lista Detalle Carrito no puede estar vacia")
	@OneToMany(mappedBy = "carrito", fetch = FetchType.LAZY)
	private List<DetalleCarrito> listaDetalleCarrito;
	
	public Carrito() {
		//listaRopas = new ArrayList<Ropa>();
		listaDetalleCarrito = new ArrayList<DetalleCarrito>();
	}

	/*public void addRopa(Ropa ropa) {
		listaRopas.add(ropa);
	}*/
	
	public void addDetalleCarrito(DetalleCarrito detalleCarrito) {
		listaDetalleCarrito.add(detalleCarrito);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	/*public List<Ropa> getListaRopas() {
		return listaRopas;
	}

	public void setListaRopas(List<Ropa> listaRopas) {
		this.listaRopas = listaRopas;
	}*/
	

	public Cliente getCliente() {
		return cliente;
	}

	public List<DetalleCarrito> getListaDetalleCarrito() {
		return listaDetalleCarrito;
	}

	public void setListaDetalleCarrito(List<DetalleCarrito> listaDetalleCarrito) {
		this.listaDetalleCarrito = listaDetalleCarrito;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
