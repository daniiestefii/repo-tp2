package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.controller.entity.Noticia;
import ar.edu.unju.fi.listas.ListaNoticia;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/noticias")
public class NoticiaController {
	/** 
	 * Inyeccion de dependencia, para utilizar el objeto de la clase
	 * sin necesidad de instanciar**/
	@Autowired
	private Noticia noticia;
	@Autowired
	private ListaNoticia listaNot;
	
	
	/**
	 * metodo getMapping que responde a una peticion /noticias/
	 * listadoNoticias para retornar a una pagina "index"(noticias) mandando a la
	 * vez la lista que contiene las noticas a la pagina para ser mostrada
	 * **/
	@GetMapping("/listadoNoticias")
	public String getNoticiaPage(Model model) {
		model.addAttribute("noticia",listaNot.getNoticias());
		return "index";
	}
	/** 
	 * metodo getMapping simple para mostrar una pagina "nuevo_noticia"
	 * enviando atravez del model un objeto tipo Noticia para ser utilizado**/
	@GetMapping("/nuevo")
	public String getNuevoNoticiaPage(Model model) {
		boolean edicion = false;
		model.addAttribute("noticia",noticia);
		model.addAttribute("edicion", edicion);
		return "nuevo_noticia"; 
	}
	/** 
	 * metodo postMapping obtiene un objeto de tipo Noticia para luego
	 * asignarlo dentro de la listaNot para su actualizacion y ser mostrado
	 * en la pagina "index" (Noticia),antes de eso tambien se obtienen los errores ocurridos
	 * y si estos ocurrieron al momento de querer mandar un objeto, se volvera a 
	 * solicitar el ingreso de el objeto (por lo que no se cambia de pagina)**/
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
	@GetMapping("/modificar/{nombre}")
	public String getModificarNoticiaPage(Model model, @PathVariable(value="nombre")String nombre){
		boolean edicion = true;
		for(Noticia noti : listaNot.getNoticias()) {
			if(noti.getTitulo().equals(nombre)){
				noticia.setTitulo(noti.getTitulo());
				noticia.setTexto(noti.getTexto());
				break;
			}
		}
		model.addAttribute("noticia", noticia);
		model.addAttribute("edicion", edicion);				
		return "nuevo_noticia";
	}
	@PostMapping("/modificar")
	public String modificarNoticia(@Valid @ModelAttribute("noticia")Noticia noti, BindingResult result) {
		
		for(Noticia noticia : listaNot.getNoticias()) {
			if(noticia.getTitulo().equals(noti.getTitulo())) {
				noticia.setTitulo(noti.getTitulo());
				noticia.setTexto(noti.getTexto());
				break;
			}
		}
		return "redirect:/noticias/listadoNoticias";
	}
	
	@GetMapping("/eliminar/{nombre}")
	public String eliminarNoticia(@PathVariable(value="nombre")String nombre) {		
		
		for(Noticia noticia : listaNot.getNoticias()) {
			if(noticia.getTitulo().equals(nombre)) {
				listaNot.getNoticias().remove(noticia);
				break;
			}
		}
		return "redirect:/noticias/listadoNoticias";
	}
}


