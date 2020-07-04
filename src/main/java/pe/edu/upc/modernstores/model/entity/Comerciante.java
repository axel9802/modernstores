package pe.edu.upc.modernstores.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comerciantes")
public class Comerciante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Por favor completar el campo usuario")
	@Column(unique = true, name = "usuario", length = 40, nullable = false)
	private String usuario;
	
	@NotBlank(message = "Por favor completar el campo contraseña")
	@Column(name = "password", length = 40, nullable = false)
	private String password;
	
	@NotBlank(message = "Por favor completar el campo celular")
	@Column(unique = true, name = "celular", nullable = false)
	private String celular;
	
	@NotBlank(message = "Por favor completar el campo correo")
	@Email(message = "No es una direccion de correo, por favor corregir sus datos")
	@Column(name = "correo", nullable = false, unique = true)
	private String correo;
	
	@NotBlank(message = "Por favor completar el campo nombres")
	@Column(name = "nombres", length = 40, nullable = false)
	private String nombres;
	
	@NotBlank(message = "Por favor completar el campo apellidos")
	@Column(name = "apellidos", length = 40, nullable = false)
	private String apellidos;
	
	@NotBlank(message = "Por favor completar el campo dni")
	@Size(min = 8, max = 8, message = "El dni debe tener 8 digitos obligatoriamente")
	@Column(unique = true, name = "dni", nullable = false)
	private String dni;
	
	//@NotEmpty(message = "La lista no puede estar vacia")
	@OneToMany(mappedBy = "comerciante", fetch = FetchType.LAZY)
	private List<TarjetaCredito> listaTarjetas;
	
	@NotNull(message = "Por favor especifique la suscripcion")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "suscripcion_id")
	private Suscripcion suscripcion;
	
	//@NotEmpty(message = "Por favor especifique la ropa")
	@ManyToMany
	@JoinTable(name = "comerciante_ropa",
			joinColumns = {@JoinColumn(name = "comerciante_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "ropa_id", referencedColumnName = "id")})
	private List<Ropa> listaRopas;
	
	public Comerciante() {
		listaTarjetas = new ArrayList<TarjetaCredito>();
		listaRopas = new ArrayList<Ropa>();
	}
	
	public void addTarjeta(TarjetaCredito tarjeta) {
		listaTarjetas.add(tarjeta);
	}
	
	public void addRopa(Ropa ropa) {
		listaRopas.add(ropa);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password= password;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<TarjetaCredito> getListaTarjetas() {
		return listaTarjetas;
	}

	public void setListaTarjetas(List<TarjetaCredito> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}

	public Suscripcion getSuscripcion() {
		return suscripcion;
	}

	public void setSuscripcion(Suscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}

	public List<Ropa> getListaRopas() {
		return listaRopas;
	}

	public void setListaRopas(List<Ropa> listaRopas) {
		this.listaRopas = listaRopas;
	}
}
