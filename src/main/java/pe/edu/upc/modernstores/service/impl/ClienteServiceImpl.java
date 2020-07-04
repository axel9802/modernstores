package pe.edu.upc.modernstores.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.modernstores.model.entity.Cliente;
import pe.edu.upc.modernstores.model.repository.ClienteRepository;
import pe.edu.upc.modernstores.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	@Transactional
	public Cliente create(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Override
	@Transactional
	public List<Cliente> readAll() throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByNombres(String nombres) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByNombres(nombres);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByApellidos(String apellidos) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByApellidos(apellidos);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findByCorreo(String correo) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByCorreo(correo);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findByUsuario(String usuario) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByUsuario(usuario);
	}

}
