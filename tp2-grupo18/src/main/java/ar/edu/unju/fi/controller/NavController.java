package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NavController {

	@GetMapping("/formulario")
	public String getFormularioPage() {
	   
		return "Formulario";
	}
	@GetMapping("/consejos")
	public String getConsejosPage() {
		
		return "ConsejodeSalud";
	}
}
