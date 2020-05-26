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
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;

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
	private Date expira;
	
	@Column(name = "tipo", length = 40, nullable = false)
	private String tipo;
	
	/*falta id_usuario e id_comerciante*/
	
}
