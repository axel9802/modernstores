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
@Table(name = "calificaciones")
public class Calificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Min(value = 1, message = "Valor minimo es 1")
	@Max(value = 10, message = "Valor maximo es 10")
	@Column(name = "puntaje")
	private int puntaje;
	
	/*falta id_usuario*/
}
