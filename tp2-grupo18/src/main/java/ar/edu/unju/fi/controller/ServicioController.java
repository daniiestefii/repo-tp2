package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.controller.model.Servicio;
import ar.edu.unju.fi.listas.ListaServicio;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	private ListaServicio listaSer;
	
	private Servicio servicio;
	
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
	public ModelAndView getGuardarProducto(@Valid @ModelAttribute("servicio")Servicio serv, BindingResult result) {
		ModelAndView mav = new ModelAndView("TablaServicios");
		if(result.hasErrors()) {
			mav.setViewName("nuevo_servicio");
			mav.addObject("servicio",serv);
			return mav;
		}
		listaSer.getServicios().add(serv);
		mav.addObject("servicio",listaSer.getServicios());
		return mav;
	}
}