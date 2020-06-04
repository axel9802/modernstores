package pe.edu.upc.modernstores.service;

import java.util.List;

import pe.edu.upc.modernstores.model.entity.Ropa;

public interface RopaService extends CrudService<Ropa, Integer>{

	List<Ropa> fetchByPrecio(double precio) throws Exception;
}
