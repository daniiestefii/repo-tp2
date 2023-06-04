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
	@GetMapping("/listadoConsejos")
	public String getConsejoPage(Model model){
		model.addAttribute("consejo",listaCon.getConsejos());
		return "ConsejodeSalud";
	}
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		model.addAttribute("consejo",consejo);
		return "nuevo_consejo"; 
	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarConsejo(@ModelAttribute("consejo")Consejo cons){
		ModelAndView mav = new ModelAndView("ConsejodeSalud");
		listaCon.getConsejos().add(cons);
		mav.addObject("consejo",listaCon.getConsejos());
		return mav;
	}
}