package pe.edu.upc.modernstores.service;

import java.util.List;

import pe.edu.upc.modernstores.model.entity.Suscripcion;

public interface SuscripcionService extends CrudService<Suscripcion, Integer>{

	List<Suscripcion> fetchByMonto(double monto) throws Exception;
}
