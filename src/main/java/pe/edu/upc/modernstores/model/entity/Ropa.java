package pe.edu.upc.modernstores.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ropas")
public class Ropa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "precio", nullable = false)
	private double precio;
	
	@Min(value = 1)
	@Max(value = 50)
	@Column(name = "stock", nullable = false)
	private int stock;
	
	/*falta id_categoria || MANY TO MANY-GENERAR TABLA Comerciante_Ropa*/
}
