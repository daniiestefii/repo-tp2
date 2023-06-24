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

import ar.edu.unju.fi.controller.entity.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/sucursales")
public class SucursalController {

	@Autowired
	private ISucursalService sucursalService;
	
	
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
		model.addAttribute("sucursal",sucursalService.getListaSucursal());
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
		boolean edicion=false;
		model.addAttribute("sucursal",sucursalService.getSucursal());
		model.addAttribute("edicion", edicion);
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
	public ModelAndView getGuardarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucu, BindingResult result) {
		ModelAndView mav = new ModelAndView("Sucursal");
		if(result.hasErrors()) {
			mav.setViewName("nuevo_sucursal");
			mav.addObject("sucursal", sucu);
			return mav;
		}
		sucursalService.guardar(sucu);
		mav.addObject("sucursal",sucursalService.getListaSucursal());
		return mav;
	}
	/**
     * @method responde a la peticion de un boton de enlace de la pagina
     * "Sucursal" donde adjunta el nombre del objeto de la lista listado.
     * el nombre es utilizado como parametro para realizar una busqueda
     * dentro de la lista y poder enviarlo por el model a un formulario
     * para poder modificarlo
     * 
     */
	@GetMapping("/modificar/{nombre}")
	public String getModificarSucursalPage(Model model, @PathVariable(value="nombre")String nombre){
		boolean edicion = true;
		Sucursal sucursalEncontrado = sucursalService.buscar(nombre);
		model.addAttribute("sucursal",sucursalEncontrado);
		model.addAttribute("edicion", edicion);				
		return "nuevo_sucursal";
	}
	/**
     * @method tras recibir el objeto el objeto modificado este actualiza
     * dicho objeto que pertence a la lista. la busqueda se realiza mediante
     * el nombre del objeto en la lista.
     */
	@PostMapping("/modificar")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucu, BindingResult result,Model model) {
		boolean edicion = true;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("sucursal",sucu);
			return "nuevo_sucursal";
		}
		sucursalService.modificar(sucu);
		return "redirect:/sucursales/listadoSucursales";
	}
	/**
     * @method elimina un objeto dentro de la lista tomando como referencia
     * de identificador el nombre que viene con la peticion a la cual
     * este metodo responde
     */
	@GetMapping("/eliminar/{nombre}")
	public String eliminarSucursal(@PathVariable(value="nombre")String nombre) {		
		sucursalService.eliminar(sucursalService.buscar(nombre));
		return "redirect:/sucursales/listadoSucursales";
	}

}