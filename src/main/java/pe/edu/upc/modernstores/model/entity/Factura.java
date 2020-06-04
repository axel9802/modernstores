package pe.edu.upc.modernstores.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@PastOrPresent(message = "La fecha debe ser pasada o presente obligatoriamente")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "fecha_factura", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaFactura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tarjeta_id")
	private TarjetaCredito tarjeta;
	
	@NotEmpty(message = "La lista no puede estar vacia")
	@OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
	private List<Detalle> listaDetalles;
	
	public Factura() {
		listaDetalles = new ArrayList<Detalle>();
	}
	
	public void addDetalle(Detalle detalle) {
		listaDetalles.add(detalle);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public TarjetaCredito getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(TarjetaCredito tarjeta) {
		this.tarjeta = tarjeta;
	}

	public List<Detalle> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<Detalle> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}
}
