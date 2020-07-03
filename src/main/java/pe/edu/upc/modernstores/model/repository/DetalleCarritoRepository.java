package pe.edu.upc.modernstores.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.modernstores.model.entity.DetalleCarrito;

@Repository
public interface DetalleCarritoRepository extends JpaRepository<DetalleCarrito, Integer>{

	List<DetalleCarrito> findByDepartamento(String departamento) throws Exception;
	List<DetalleCarrito> findByDistrito(String distrito) throws Exception;
}
