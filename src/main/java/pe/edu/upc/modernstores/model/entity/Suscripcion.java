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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "suscripciones")
public class Suscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@PastOrPresent(message = "La fecha de suscripcion debe ser pasado o presente obligatoriamente")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "fecha_suscripcion", nullable = false)
	private Date fechaSuscripcion;
	
	@Positive(message = "El monto debe ser mayor a cero")
	@Column(name = "monto", nullable = false)
	private double monto;
	
	@Size(min = 7, max = 7)
	@NotBlank(message = "Por favor completar el campo nombre")
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;
	
	@NotEmpty(message = "La lista no puede estar vacia")
	@OneToMany(mappedBy = "suscripcion", fetch = FetchType.LAZY)
	private List<Comerciante> listaComerciantes;
	
	public Suscripcion() {
		listaComerciantes = new ArrayList<Comerciante>();
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

	public Date getFechaSuscripcion() {
		return fechaSuscripcion;
	}

	public void setFechaSuscripcion(Date fechaSuscripcion) {
		this.fechaSuscripcion = fechaSuscripcion;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Comerciante> getListaComerciantes() {
		return listaComerciantes;
	}

	public void setListaComerciantes(List<Comerciante> listaComerciantes) {
		this.listaComerciantes = listaComerciantes;
	}
}
