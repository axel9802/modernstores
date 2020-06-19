package pe.edu.upc.modernstores.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.modernstores.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsername( String username ) throws Exception;
}
