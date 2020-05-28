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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "detalles")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Positive(message = "La cantidad comprada debe ser mayor a cero")
	@NotBlank(message = "Por favor completar el campo cantidad")
	@Column(name = "cantidad_comprada", nullable = false)
	private int cantidadComprada;
	
	@Positive(message = "El monto debe ser mayor a cero")
	@NotBlank(message = "Por favor completar el campo monto a pagar")
	@Column(name = "monto_pagar", nullable = false)
	private double montoPagar;
	
	@NotNull(message = "Por favor especifique la factura")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "factura_id")
	private Factura factura;
	
	@NotNull(message = "Por favor especifique la ropa")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ropa_id")
	private Ropa ropa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	public double getMontoPagar() {
		return montoPagar;
	}

	public void setMontoPagar(double montoPagar) {
		this.montoPagar = montoPagar;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Ropa getRopa() {
		return ropa;
	}

	public void setRopa(Ropa ropa) {
		this.ropa = ropa;
	}
}
