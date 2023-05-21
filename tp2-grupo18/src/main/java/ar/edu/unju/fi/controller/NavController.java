package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NavController {

	@GetMapping("/formulario")
	public String getFormularioPage() {
	   
		return "Formulario";
	}
	@GetMapping("/index")
	public String getIndexPage() {
		
		return "index";
	}
	@GetMapping("/consejos")
	public String getConsejosPage() {
		
		return "ConsejodeSalud";
	}
	@GetMapping("/servicios")
	public String getServiciosPage() {
		
		return "TablaServicios";
	}
	@GetMapping("/sucursal")
	public String getSucursalPage() {
		
		return "Sucursal";
	}
}
