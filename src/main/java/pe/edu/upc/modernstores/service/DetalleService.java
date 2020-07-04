package pe.edu.upc.modernstores.service;

import java.util.List;

import pe.edu.upc.modernstores.model.entity.Detalle;

public interface DetalleService extends CrudService<Detalle, Integer>{

	List<Detalle> fetchByMonto(double montoPagar) throws Exception;
}
