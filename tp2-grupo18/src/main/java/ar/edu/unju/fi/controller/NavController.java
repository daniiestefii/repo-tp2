package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NavController {

	/** 
	 * Metodo getMapping para acceder a la pagina html con el nombre
	 * "Formulario" simple clase @Controller
	 * **/
	@GetMapping("/formulario")
	public String getFormularioPage() {
	    
		return "Formulario";
	}
}