package pe.edu.upc.modernstores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("modernstores/starter")
public class StarterController {

	@GetMapping("/inicio")
	public String starter() {
		return "/inicio/inicio";
	}
}


