package pe.edu.upc.modernstores.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.modernstores.model.entity.DetalleCarrito;
import pe.edu.upc.modernstores.model.repository.DetalleCarritoRepository;
import pe.edu.upc.modernstores.service.DetalleCarritoService;

@Service
public class DetalleCarritoServiceImpl implements DetalleCarritoService{

	private DetalleCarritoRepository detalleCarritoRepository;
	
	@Override
	@Transactional
	public DetalleCarrito create(DetalleCarrito entity) throws Exception {
		// TODO Auto-generated method stub
		return detalleCarritoRepository.save(entity);
	}

	@Override
	@Transactional
	public List<DetalleCarrito> readAll() throws Exception {
		// TODO Auto-generated method stub
		return detalleCarritoRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<DetalleCarrito> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return detalleCarritoRepository.findById(id);
	}

	@Override
	@Transactional
	public DetalleCarrito update(DetalleCarrito entity) throws Exception {
		// TODO Auto-generated method stub
		return detalleCarritoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		detalleCarritoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		detalleCarritoRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleCarrito> findByDepartamento(String departamento) throws Exception {
		// TODO Auto-generated method stub
		return detalleCarritoRepository.findByDepartamento(departamento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleCarrito> findByDistrito(String distrito) throws Exception {
		// TODO Auto-generated method stub
		return detalleCarritoRepository.findByDistrito(distrito);
	}
}
