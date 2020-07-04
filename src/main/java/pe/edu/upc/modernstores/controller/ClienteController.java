package pe.edu.upc.modernstores.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.modernstores.model.entity.Cliente;
import pe.edu.upc.modernstores.service.ClienteService;


@Controller
@RequestMapping("modernstores/clientes")
@SessionAttributes("cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public String start(Model model) {
		try {
			List<Cliente> clientes=clienteService.readAll();
			model.addAttribute("clientes", clientes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/listall";
	}
	@GetMapping("/new")
	public String nuevo(Model model) {
		Cliente cliente=new Cliente();
		model.addAttribute("cliente",cliente);
		return "/cliente/nuevo";
	}
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result,Model model,SessionStatus status) {
		
		if (result.hasFieldErrors()) {
			return "/cliente/nuevo";
		}
		
		try {
			clienteService.create(cliente);
			status.setComplete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/modernstores/clientes";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,Model model) {
		try {
			Optional<Cliente> optional=clienteService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("cliente", optional.get());
			}else {
				return "redirect:/modernstores/clientes";
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/edit";
	}
	@GetMapping("/del/{id}")
	public String delete(@PathVariable("id") Integer id,Model model) {
		try {
			Optional<Cliente> optional=clienteService.findById(id);
			if(optional.isPresent()) {
				clienteService.deleteById(id);
			}else {
				return "redirect:/modernstores/clientes";
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/modernstores/clientes";
	}
	
}
