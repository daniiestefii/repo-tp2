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
	@Autowired
	private Servicio servicio;

	/*
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a
	 * la ruta "/listadoServicios".
	 * Devuelve la vista "TablaServicios" con un modelo que contiene una lista de
	 * servicios".
	 *
	 * @param model:el objeto de modelo al que se agrega la lista de servicios
	 * @return el nombre de vista "TablaServicios"
	 */
	@GetMapping("/listadoServicios")
	public String getServicioPage(Model model) {
		model.addAttribute("servicio",listaSer.getServicios());
		return "TablaServicios";
	}

	/*
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la ruta "/nuevo".
	 * Devuelve la vista "nuevo_servicio" con un modelo que contiene un objeto "servicio".
	 *
	 * @param model:el objeto de modelo al que se agrega el objeto "servicio"
	 * @return el nombre de vista "nuevo_servicio"
	 */
	@GetMapping("/nuevo")
	public String getNuevoServicioPage(Model model) {
		model.addAttribute("servicio",servicio);
		return "nuevo_servicio"; 
	}

	/*
	 * Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la ruta "/guardar".
	 * Agrega un objeto "serv" a una lista de servicios en un objeto "listaSer".
	 * Devuelve la vista "TablaServicios" con un modelo que contiene la lista actualizada de servicios.
	 *
	 * @param serv:el objeto de servicio que se agrega a la lista de servicios
	 * @return el objeto ModelAndView que contiene la vista "TablaServicios" y el modelo actualizado
	 *  de servicios
	 */
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