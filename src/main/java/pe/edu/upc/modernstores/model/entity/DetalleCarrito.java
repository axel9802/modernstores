package pe.edu.upc.modernstores.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "detalles_carrito")
public class DetalleCarrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Por favor completar el campo departamento")
	@Column(name = "departamento", length = 40, nullable = false)
	private String departamento;
	
	@NotBlank(message = "Por favor completar el campo distrito")
	@Column(name = "distrito", length = 40, nullable = false)
	private String distrito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ropa_id")
	private Ropa ropa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrito_id")
	private Carrito carrito;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Ropa getRopa() {
		return ropa;
	}

	public void setRopa(Ropa ropa) {
		this.ropa = ropa;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
}
