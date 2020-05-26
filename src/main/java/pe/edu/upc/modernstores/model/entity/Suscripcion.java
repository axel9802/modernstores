package pe.edu.upc.modernstores.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PastOrPresent;

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
	
	@Column(name = "monto", nullable = false)
	private double monto;
	
	@Column(name = "estado", length = 20, nullable = false)
	private String estado;
	
	/*falta id_vendedor*/
}
