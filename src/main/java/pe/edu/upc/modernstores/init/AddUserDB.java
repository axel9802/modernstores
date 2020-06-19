package pe.edu.upc.modernstores.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import pe.edu.upc.modernstores.model.entity.Usuario;
import pe.edu.upc.modernstores.model.repository.AuthorityRepository;
import pe.edu.upc.modernstores.model.repository.UsuarioRepository;

@Service
public class AddUserDB implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	/*@Autowired
	private PasswordEncoder passwordEncoder; */
	
	@Override
	public void run(String... args) throws Exception {
		
		//SOLO DESBLOQUEAR CUANDO SE REQUIERA CREAR USUARIO DE FORMA MANUAL
		
		/*Usuario cliente = new Usuario();
		cliente.setUsername("cliente1");
		cliente.setPassword(new BCryptPasswordEncoder().encode("cliente"));
		cliente.setEnable(true);
		
		Usuario comerciante = new Usuario();
		comerciante.setUsername("comerciante1");
		comerciante.setPassword(new BCryptPasswordEncoder().encode("comerciante"));
		comerciante.setEnable(true);
		
		Usuario administrador = new Usuario();
		administrador.setUsername("administrador1");
		administrador.setPassword(new BCryptPasswordEncoder().encode("administrador"));
		administrador.setEnable(true);
		
		cliente.addAuthority("ROLE_CLIENTE");
		//cliente.addAuthority("ACCESS_ADDBUY");
		//cliente.addAuthority("ACCESS_ADDPURCHASE");
		
		comerciante.addAuthority("ROLE_COMERCIANTE");
		comerciante.addAuthority("ACCESS_ADDCLOTHES");
		comerciante.addAuthority("ACCESS_EDITCLOTHES");
		comerciante.addAuthority("ACCESS_DELCLOTHES");
		
		administrador.addAuthority("ROLE_ADMINISTRADOR");
		administrador.addAuthority("ACCESS_EDITCLOTHES");
		administrador.addAuthority("ACCESS_DELCLOTHER");
		administrador.addAuthority("ACCESS_ADDMERCHANT");
		administrador.addAuthority("ACCESS_DELMERCHANT");
		administrador.addAuthority("ACCESS_EDITMERCHANT"); 
		
		usuarioRepository.save(cliente);
		usuarioRepository.save(comerciante);
		usuarioRepository.save(administrador); */
		
	}

}
