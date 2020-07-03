package pe.edu.upc.modernstores.service;

import java.util.List;

import pe.edu.upc.modernstores.model.entity.Categoria;

public interface CategoriaService extends CrudService<Categoria, Integer>{

	List<Categoria> findByNombre(String nombre) throws Exception;
}
