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

	/*
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la ruta
	 * "/listadoSucursales".
	 * Devuelve la vista "Sucursal" con un modelo que contiene la lista de sucursales en un
	 * objeto "listaSucu".
	 *
	 * @param model:el objeto de modelo al que se agrega la lista de sucursales
	 * @return el nombre de vista "Sucursal" con el modelo actualizado de sucursales
	 */
	@GetMapping("/listadoSucursales")
	public String getSucursalPage(Model model) {
		model.addAttribute("sucursal",listaSucu.getSucursales());
		return "Sucursal";
	}

	/*
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la ruta "/nuevo".
	 * Devuelve la vista "nuevo_sucursal" con un modelo que contiene un objeto "sucursal".
	 *
	 * @param model:el objeto de modelo al que se agrega el objeto "sucursal"
	 * @return el nombre de vista "nuevo_sucursal" con el modelo actualizado de sucursal
	 */
	@GetMapping("/nuevo")
	public String getNuevoSucursalPage(Model model) {
		model.addAttribute("sucursal",sucursal);
		return "nuevo_sucursal"; 
	}

	/*
	 * Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la ruta "/guardar".
	 * Agrega un objeto "sucursal" a una lista de sucursales en un objeto "listaSucu".
	 * Devuelve la vista "Sucursal" con un modelo que contiene la lista actualizada de sucursales.
	 *
	 * @param sucu:el objeto "sucursal" que se agrega a la lista de sucursales
	 * @return el objeto ModelAndView con el nombre de vista "Sucursal" y el modelo actualizado de
	 * sucursales
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursal(@ModelAttribute("sucursal")Sucursal sucu) {
		ModelAndView mav = new ModelAndView("Sucursal");
		listaSucu.getSucursales().add(sucu);
		mav.addObject("sucursal",listaSucu.getSucursales());
		return mav;
	}
}