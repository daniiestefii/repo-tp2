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

import ar.edu.unju.fi.controller.model.Noticia;
import ar.edu.unju.fi.listas.ListaNoticia;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/noticias")
public class NoticiaController {

	@Autowired
	private ListaNoticia listaNot;
	
	
	private Noticia noticia;
	
	@GetMapping("/listadoNoticias")
	public String getNoticiaPage(Model model) {
		model.addAttribute("noticia",listaNot.getNoticias());
		return "index";
	}
	@GetMapping("/nuevo")
	public String getNuevoNoticiaPage(Model model) {
		model.addAttribute("noticia",new Noticia("",""));
		return "nuevo_noticia"; 
	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarNoticia(@Valid @ModelAttribute("noticia")Noticia noti, BindingResult result) {
		ModelAndView mav = new ModelAndView("index");
		if(result.hasErrors()) {
			mav.setViewName("nuevo_noticia");
			mav.addObject("nuevo_noticia", noti);
			return mav;
		}
		listaNot.getNoticias().add(noti);
		mav.addObject("noticia",listaNot.getNoticias());
		return mav;
	}
}