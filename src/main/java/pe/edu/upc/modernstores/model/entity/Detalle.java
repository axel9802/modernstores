package pe.edu.upc.modernstores.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalles")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cantidad_comprada", nullable = false)
	private int cantidadComprada;
	
	@Column(name = "monto_pagar", nullable = false)
	private double montoPagar;
	
	/*falta id_factura_ropa_calificacion*/
}
