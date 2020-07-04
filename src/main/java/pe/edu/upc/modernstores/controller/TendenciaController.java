package pe.edu.upc.modernstores.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.modernstores.model.entity.Detalle;
import pe.edu.upc.modernstores.model.entity.Factura;
import pe.edu.upc.modernstores.model.entity.Ropa;
import pe.edu.upc.modernstores.service.DetalleService;
import pe.edu.upc.modernstores.service.FacturaService;
import pe.edu.upc.modernstores.service.RopaService;

@Controller
@RequestMapping("modernstores/tendencia")
@SessionAttributes("detalle")
public class TendenciaController {

	@Autowired
	private DetalleService detalleService; 
	
	@Autowired
	private RopaService ropaService;
	
	@Autowired
	private FacturaService facturaService;
	
	@GetMapping
	public String start() {
		return "/tendencia/start";
	}
	
	@GetMapping("/listarCompras")
	public String listaCompras(Model model) {
		try {
			List<Detalle> listaDetalles = detalleService.readAll();
			model.addAttribute("listaDetalles", listaDetalles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/tendencia/listaCompras";
	}
	
	@GetMapping("/nuevo")
	public String Compra(Model model) {
		Detalle detalle = new Detalle();
		model.addAttribute("detalle", detalle);
		
		try {
			List<Ropa> listaRopas = ropaService.readAll();  //Aqui se muestra las listas en los check box del proceso comprar para solo elegir
			model.addAttribute("listaRopas", listaRopas);
			
			List<Factura> listaFacturas = facturaService.readAll();
			model.addAttribute("listaFacturas", listaFacturas);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/tendencia/nuevo";
	}
	
	@PostMapping("/comprar")
	public String NuevaCompra(@ModelAttribute("detalle") Detalle detalle, Model model, SessionStatus status) {
		
		try {
			detalleService.create(detalle);
			status.setComplete();
			List<Detalle> listaDetalles = detalleService.readAll();
			model.addAttribute("listaDetalles", listaDetalles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/tendencia/listaCompras";
	}
}
