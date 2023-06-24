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
import ar.edu.unju.fi.service.INoticiaService;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/noticias")
public class NoticiaController {
	/** 
	 * Inyeccion de dependencia, para utilizar el objeto de la clase
	 * sin necesidad de instanciar**/
	@Autowired
	private Noticia noticia;
	/** servicio*/
	@Autowired
	private INoticiaService noticiaService;
	
	
	/** metodo getMapping que envia a la vista una lista de objetos de
	 * la base de datos, la vista es una pagina index*/
	@GetMapping("/listadoNoticias")
	public String getNoticiaPage(Model model) {
		model.addAttribute("noticia",noticiaService.getListaNoticias());
		return "index";
	}
	/** 
	 * metodo getMapping simple para mostrar una pagina "nuevo_noticia"
	 * enviando atravez del model un objeto tipo Noticia para ser utilizado**/
	@GetMapping("/nuevo")
	public String getNuevoNoticiaPage(Model model) {
		boolean edicion = false;
		model.addAttribute("noticia",noticiaService.getNoticia());
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
		noticiaService.guardar(noti);
		mav.addObject("noticia",noticiaService.getListaNoticias());
		
		return mav;
	}
	/** metodo getMapping que utiliza una variable enviada por la peticion
	 * la cual es utilizada para identificar el objeto dentro de una lista de
	 * la base de datos, el objeto es enviado a la vista de otra pagina para
	 * ser modificado en un formulario*/
	@GetMapping("/modificar/{id}")
	public String getModificarNoticiaPage(Model model, @PathVariable(value="id")Long id){
		boolean edicion = true;
		Noticia noticia = noticiaService.buscar(id);
		model.addAttribute("noticia", noticia);
		model.addAttribute("edicion", edicion);				
		return "nuevo_noticia";
	}
	/** metodo postMapping que utiliza un objeto de la vista a la cual
	 * realiza la peticion para modificar ese mismo objeto en su tabla
	 * correspondiente, si es que no es enviado con errores el objeto de lo
	 * contrario se vuelve a enviar el mismo objeto al formulario*/
	@PostMapping("/modificar")
	public String modificarNoticia(@Valid @ModelAttribute("noticia")Noticia noti, BindingResult result,Model model) {
		boolean edicion = true;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("noticia",noti);
			return "nuevo_noticia";
		}
		noticiaService.modificar(noti);
		return "redirect:/noticias/listadoNoticias";
	}
	/** metodo getMapping que utiliza una variable enviada por peticion
	 * este metodo simplemente busca con el parametro identificador
	 * a un determinado objeto dentro de una tabla determinada y cambia
	 * su estado a false*/
	@GetMapping("/eliminar/{id}")
	public String eliminarNoticia(@PathVariable(value="id")Long id) {		
		noticiaService.eliminar(noticiaService.buscar(id));
		return "redirect:/noticias/listadoNoticias";
	}
}


