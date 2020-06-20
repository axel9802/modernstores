package pe.edu.upc.modernstores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("modernstores/inicio")
public class InicioController {

	@GetMapping
	public String start() {
		return "/inicio/inicio";
	}
}
