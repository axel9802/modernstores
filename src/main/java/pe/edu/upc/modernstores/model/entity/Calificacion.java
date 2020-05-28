package pe.edu.upc.modernstores.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
	
	@NotNull(message = "Por favor especifique el Cliente")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@NotNull(message = "Por favor especifique la Ropa")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ropa_id")
	private Ropa ropa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Ropa getRopa() {
		return ropa;
	}

	public void setRopa(Ropa ropa) {
		this.ropa = ropa;
	}
}
