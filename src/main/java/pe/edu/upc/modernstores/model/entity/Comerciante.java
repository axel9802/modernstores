package pe.edu.upc.modernstores.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comerciantes")
public class Comerciante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, name = "usuario", length = 40, nullable = false)
	private String usuario;
	
	@Column(name = "contraseña", length = 40, nullable = false)
	private String contraseña;
	
	@Column(unique = true, name = "celular", nullable = false)
	private String celular;
	
	@Column(name = "correo", nullable = false, unique = true)
	private String correo;
	
	@Column(name = "nombres", length = 40, nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", length = 40, nullable = false)
	private String apellidos;
	
	@Size(min = 8, max = 8, message = "El dni debe tener 8 digitos obligatoriamente")
	@Column(unique = true, name = "dni", nullable = false)
	private String dni;
	
	/*MANY TO MANY-GENERAR TABLA Comerciante_Ropa*/
}
