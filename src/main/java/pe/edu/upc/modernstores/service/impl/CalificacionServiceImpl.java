package pe.edu.upc.modernstores.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.modernstores.model.entity.Calificacion;
import pe.edu.upc.modernstores.model.repository.CalificacionRepository;
import pe.edu.upc.modernstores.service.CalificacionService;

@Service
public class CalificacionServiceImpl implements CalificacionService{

	@Autowired
	private CalificacionRepository calificacionRepository;
	
	@Override
	@Transactional
	public Calificacion create(Calificacion entity) throws Exception {
		return calificacionRepository.save(entity);
	}

	@Override
	@Transactional
	public List<Calificacion> readAll() throws Exception {
		// TODO Auto-generated method stub
		return calificacionRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Calificacion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return calificacionRepository.findById(id);
	}

	@Override
	@Transactional
	public Calificacion update(Calificacion entity) throws Exception {
		// TODO Auto-generated method stub
		return calificacionRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		calificacionRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		calificacionRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Calificacion> findByPuntaje(int Puntaje) throws Exception {
		// TODO Auto-generated method stub
		return calificacionRepository.findByPuntaje(Puntaje);
	}

}
