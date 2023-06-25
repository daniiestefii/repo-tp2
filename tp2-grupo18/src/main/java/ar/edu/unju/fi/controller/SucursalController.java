package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.service.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.controller.entity.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;


/**
 * @model Sucursal
 * @author DOrdonez, MiltonDelgado
 */
@Controller
@RequestMapping("/sucursales")
public class SucursalController {
	/** sucursal*/
	@Autowired
	private ISucursalService sucursalService;
	/** provincia*/
	@Autowired
	private IProvinciaService provinciaService;

	/** metodo de filtrado que muestra la misma pagina de donde se lo utiliza
	 * pero con la diferencia de los objetos a listar de la tabla*/
	@GetMapping("/filtradoSucursales")
	public String getfiltradoSucursalesPage(@RequestParam("fechainicio") String fechainicio,@RequestParam("fechafin") String fechafin ,Model model) {
		model.addAttribute("sucursal", sucursalService.getListaSucursalesFiltradosForFecha(fechainicio,fechafin));
		return "Sucursal";
	}
	
	
	/**
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
		model.addAttribute("sucursal",sucursalService.getListaSucursales());
		model.addAttribute("provincias",provinciaService.getListaProvincias());
		return "Sucursal";
	}
	/**
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
		model.addAttribute("provincias", provinciaService.getListaProvincias());
		model.addAttribute("edicion", edicion);
		return "nuevo_sucursal"; 
	}

	/**
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
			mav.addObject("provincias", provinciaService.getListaProvincias());
			return mav;
		}
		sucu.setEstado(true);
		//sucu.setProvincia(provinciaService.buscar(1L));
		sucursalService.guardar(sucu);
		mav.addObject("sucursal",sucursalService.getListaSucursales());
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
	public String getModificarSucursalPage(Model model, @PathVariable(value="nombre")Long nombre){
		boolean edicion = true;
		Sucursal sucursalEncontrado = sucursalService.buscar(nombre);
		model.addAttribute("sucursal",sucursalEncontrado);
		model.addAttribute("provincias", provinciaService.getListaProvincias());
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
			model.addAttribute("provincias", provinciaService.getListaProvincias());
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
	public String eliminarSucursal(@PathVariable(value="nombre")Long nombre) {
		sucursalService.eliminar(sucursalService.buscar(nombre));
		return "redirect:/sucursales/listadoSucursales";
	}

}