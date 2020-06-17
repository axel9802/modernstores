package pe.edu.upc.modernstores.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tarjeta_creditos")
public class TarjetaCredito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 16, max = 16, message = "El tamaño debe ser de 16 caracteres")
	@Column(name = "numero_tarjeta", nullable = false)
	private String numeroTarjeta;
	
	@Size(min = 3, max = 3, message = "El mensaje debe ser de 3 caracteres")
	@Column(name = "codigo_control", nullable = false)
	private String codigoControl;
	
	@FutureOrPresent(message = "La fecha debe caducar obligatoriamente en una fecha futura o presente")
	@Column(name = "expira", nullable = false)
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expira;
	
	@NotBlank(message = "Por favor completar el campo tipo")
	@Column(name = "tipo", length = 40, nullable = false)
	private String tipo;
	
	@NotNull(message = "Por favor especifique el cliente")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@NotNull(message = "Por favor especifique el comerciante")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comerciante_id")
	private Comerciante comerciante;
	
	/*@NotEmpty(message = "La lista no puede estar vacia")
	@OneToMany(mappedBy = "tarjeta", fetch = FetchType.LAZY)
	private List<Factura> listaFacturas;*/
	
	public TarjetaCredito() {
		//listaFacturas = new ArrayList<Factura>();
	}
	
	/*public void addFactura(Factura factura) {
		listaFacturas.add(factura);
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getCodigoControl() {
		return codigoControl;
	}

	public void setCodigoControl(String codigoControl) {
		this.codigoControl = codigoControl;
	}

	public Date getExpira() {
		return expira;
	}

	public void setExpira(Date expira) {
		this.expira = expira;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Comerciante getComerciante() {
		return comerciante;
	}

	public void setComerciante(Comerciante comerciante) {
		this.comerciante = comerciante;
	}

	/*public List<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}*/
}
