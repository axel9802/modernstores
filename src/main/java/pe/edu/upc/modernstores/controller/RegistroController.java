package pe.edu.upc.modernstores.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.modernstores.model.entity.Usuario;
import pe.edu.upc.modernstores.service.UsuarioService;

@Controller
@RequestMapping("modernstores/register")
@SessionAttributes("usuario")
public class RegistroController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private String password;
	
	@GetMapping("cliente")
	public String startCl(Model model) {
		Usuario usuario = new Usuario();
		usuario.addAuthority("ROLE_CLIENTE");
		usuario.setEnable(true);
		model.addAttribute("usuario", usuario);
		return "/usuario/register";
	}
	@GetMapping("comerciante")
	public String startCo(Model model) {
		Usuario usuario = new Usuario();
		usuario.addAuthority("ROLE_COMERCIANTE");
		usuario.setEnable(true);
		model.addAttribute("usuario", usuario);
		return "/usuario/register";
	}
	@PostMapping("/save")
	public String save(@Valid Usuario usuario, BindingResult result, Model model,SessionStatus status) {
		
		if (result.hasFieldErrors()) {
			return "/usuario/register";
		}
		
		try {	
			this.password=usuario.getPassword();
			usuario.setPassword(passwordEncoder.encode(this.password));
			usuarioService.create(usuario);
			status.setComplete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/modernstores/inicio/login";
	}
}
