package pe.edu.upc.modernstores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("modernstores/starter")
public class StarterController {

	@GetMapping(value= {"/inicio","/"})
	public String starter() {
		return "/inicio/inicio";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("access-denied")
	public String accessDenied() {
		return "access-denied";
	}
}


