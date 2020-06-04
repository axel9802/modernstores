package pe.edu.upc.modernstores.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.modernstores.model.entity.TarjetaCredito;

public interface TarjetaCreditoService extends CrudService<TarjetaCredito, Integer>{

	Optional<TarjetaCredito> findByNumeroTarjeta(String numeroTarjeta) throws Exception;
	List<TarjetaCredito> findByTipo(String tipo) throws Exception;
}
