package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.controller.model.Consejo;
import ar.edu.unju.fi.listas.ListaConsejo;



@Controller
@RequestMapping("/consejos")
public class ConsejoController {

	@Autowired
	private ListaConsejo listaCon;
	private Consejo consejo;

	/*
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la ruta "/listadoConsejos".
	 * Devuelve la vista "ConsejodeSalud" con un modelo que contiene una lista de consejos.
	 *
	 * @param model:el objeto de modelo al que se agrega la lista de consejos
	 * @return el nombre de vista "ConsejodeSalud"
	 */
	@GetMapping("/listadoConsejos")
	public String getConsejoPage(Model model){
		model.addAttribute("consejo",listaCon.getConsejos());
		return "ConsejodeSalud";
	}

	/*
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la ruta "/nuevo".
	 * Devuelve la vista "nuevo_consejo" con un modelo que contiene un objeto "consejo".
	 *
	 * @param model:el objeto de modelo al que se agrega el objeto "consejo"
	 * @return el nombre de vista "nuevo_consejo"
	 */
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		model.addAttribute("consejo",consejo);
		return "nuevo_consejo"; 
	}

	/*
	 * Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la ruta "/guardar".
	 * Agrega un objeto "consejo" a una lista de consejos".
	 * Devuelve la vista "ConsejodeSalud" con un modelo que contiene la lista actualizada de consejos.
	 *
	 * @param cons:el objeto "consejo" que se agrega a la lista de consejos
	 * @return el objeto ModelAndView que contiene la vista "ConsejodeSalud" y el modelo actualizado
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarConsejo(@ModelAttribute("consejo")Consejo cons){
		ModelAndView mav = new ModelAndView("ConsejodeSalud");
		listaCon.getConsejos().add(cons);
		mav.addObject("consejo",listaCon.getConsejos());
		return mav;
	}
}