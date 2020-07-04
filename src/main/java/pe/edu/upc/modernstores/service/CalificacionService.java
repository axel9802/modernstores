package pe.edu.upc.modernstores.service;

import java.util.List;

import pe.edu.upc.modernstores.model.entity.Calificacion;

public interface CalificacionService extends CrudService<Calificacion, Integer>{

	List<Calificacion> findByPuntaje(int Puntaje) throws Exception;
}
