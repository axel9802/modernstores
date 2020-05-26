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
@Table(name = "facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@PastOrPresent(message = "La fecha debe ser pasada o presente obligatoriamente")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "fecha_factura", nullable = false)
	private Date fechaFactura;
	
	/*falta id_tarjeta*/
}
