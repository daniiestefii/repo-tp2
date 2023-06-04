package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.controller.model.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;



@Controller
@RequestMapping("/sucursales")
public class SucursalController {

	@Autowired
	private ListaSucursal listaSucu;
	
	private Sucursal sucursal;
	@GetMapping("/listadoSucursales")
	public String getSucursalPage(Model model) {
		model.addAttribute("sucursal",listaSucu.getSucursales());
		return "Sucursal";
	}
	@GetMapping("/nuevo")
	public String getNuevoSucursalPage(Model model) {
		model.addAttribute("sucursal",sucursal);
		return "nuevo_sucursal"; 
	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursal(@ModelAttribute("sucursal")Sucursal sucu) {
		ModelAndView mav = new ModelAndView("Sucursal");
		listaSucu.getSucursales().add(sucu);
		mav.addObject("sucursal",listaSucu.getSucursales());
		return mav;
	}
}