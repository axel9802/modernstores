package pe.edu.upc.modernstores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.modernstores.model.entity.DetalleCarrito;

@Controller
@RequestMapping("modernstores/carrito")
@SessionAttributes("detalleCarrito")
public class DetalleCarritoController {

	/*@Autowired
	private DetalleCarrito detalleCarrito;*/
	
	@GetMapping
	public String start(){
		
		return "starter";
	}
}
