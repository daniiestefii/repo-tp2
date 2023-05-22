package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.controller.model.Servicio;
import ar.edu.unju.fi.listas.ListaServicio;



@Controller
@RequestMapping("/servicios")
public class ServicioController {

	ListaServicio listaSer = new ListaServicio();
	
	@GetMapping("/listadoServicios")
	public String getServicioPage(Model model) {
		model.addAttribute("servicio",listaSer.getServicios());
		return "TablaServicios";
	}
	@GetMapping("/nuevo")
	public String getNuevoServicioPage(Model model) {
		model.addAttribute("servicio",new Servicio("","",""));
		return "nuevo_servicio"; 
	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarProducto(@ModelAttribute("servicio")Servicio serv) {
		ModelAndView mav = new ModelAndView("TablaServicios");
		listaSer.getServicios().add(serv);
		mav.addObject("servicio",listaSer.getServicios());
		return mav;
	}
}