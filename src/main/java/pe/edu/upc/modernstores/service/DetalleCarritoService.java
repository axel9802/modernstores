package pe.edu.upc.modernstores.service;

import java.util.List;

import pe.edu.upc.modernstores.model.entity.DetalleCarrito;

public interface DetalleCarritoService extends CrudService<DetalleCarrito, Integer>{

	List<DetalleCarrito> findByDepartamento(String departamento) throws Exception;
	List<DetalleCarrito> findByDistrito(String distrito) throws Exception;
}
