package pe.edu.upc.modernstores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.modernstores.model.entity.Carrito;
import pe.edu.upc.modernstores.model.entity.DetalleCarrito;
import pe.edu.upc.modernstores.model.entity.Ropa;
import pe.edu.upc.modernstores.service.CarritoService;
import pe.edu.upc.modernstores.service.DetalleCarritoService;
import pe.edu.upc.modernstores.service.RopaService;

@Controller
@RequestMapping("modernstores/ropacarrito")
@SessionAttributes("detalleCarrito")
public class DetalleCarritoController {

	@Autowired
	private DetalleCarritoService detalleCarritoService; 
	
	@Autowired
	private CarritoService carritoService;
	
	@Autowired
	private RopaService ropaService;
	
	@GetMapping
	public String start(){
		
		return "/carrito/ropaCarrito";
	}
	
	@GetMapping("/listarRopaCarrito")
	public String listarCarrito(Model model) {
		try {
			List<DetalleCarrito> listaDetalleCarritos = detalleCarritoService.readAll();
			model.addAttribute("listaDetalleCarritos", listaDetalleCarritos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"/carrito/listarRopa";
	}
	
	@GetMapping("/nuevo")
	public String NuevaRopa(Model model) {
		
		DetalleCarrito detalleCarrito = new DetalleCarrito();
		model.addAttribute("detalleCarrito", detalleCarrito);
		
		try {
			List<Carrito> listaCarritos = carritoService.readAll(); //Para que en el proceso compra me muestre los datos de las otras listas en los checkBox
			model.addAttribute("listaCarritos", listaCarritos);
			
			List<Ropa> listaRopas = ropaService.readAll();
			model.addAttribute("listaRopas", listaRopas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"/carrito/ropaCarrito";
	}
	
	@PostMapping("/nuevaRopaCarrito") //el nombre no necesariamente debe ser igual al de la funcion
	public String NuevaRopaCarrito(@ModelAttribute("detalleCarrito") DetalleCarrito detalleCarrito, Model model, SessionStatus status) {
	
		try {
			detalleCarritoService.create(detalleCarrito);
			status.setComplete();
			List<DetalleCarrito> listaDetalleCarritos = detalleCarritoService.readAll(); //Estas dos lineas las agrego en la creacion para que me muestre la nueva lista con este nuevo objeto creado
			model.addAttribute("listaDetalleCarritos", listaDetalleCarritos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/carrito/listarRopa";
	}
}
