package pe.edu.upc.modernstores.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.modernstores.model.entity.Comerciante;

public interface ComercianteService extends CrudService<Comerciante, Integer>{

	Optional<Comerciante> findByUsuario(String usuario) throws Exception;
	Optional<Comerciante> findByCelular(String celular) throws Exception;
	Optional<Comerciante> findByCorreo(String correo) throws Exception;
	List<Comerciante> findByNombres(String nombres) throws Exception;
	List<Comerciante> findByApellidos(String apellidos) throws Exception;
	Optional<Comerciante> findByDni(String dni) throws Exception;
}
