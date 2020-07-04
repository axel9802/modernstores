package pe.edu.upc.modernstores.service;

import java.util.Optional;

import pe.edu.upc.modernstores.model.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long>{
	Optional<Usuario> findByUsername( String username ) throws Exception;
}
