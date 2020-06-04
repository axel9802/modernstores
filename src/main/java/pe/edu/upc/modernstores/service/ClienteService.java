package pe.edu.upc.modernstores.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.modernstores.model.entity.Cliente;

public interface ClienteService extends CrudService<Cliente, Integer>{

	List<Cliente> findByNombres(String nombres) throws Exception;
	List<Cliente> findByApellidos(String apellidos) throws Exception;
	Optional<Cliente> findByCorreo(String correo) throws Exception;
	Optional<Cliente> findByUsuario(String usuario) throws Exception;
}
