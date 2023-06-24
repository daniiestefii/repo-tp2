package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.controller.entity.Categoria;
import ar.edu.unju.fi.controller.entity.Empleado;
import ar.edu.unju.fi.controller.entity.Producto;
import ar.edu.unju.fi.service.ICategoriaService;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/empleados")

public class EmpleadoController{
    
	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("/listadoEmpleado")
	public String getEmpleadoPage(Model model){
		model.addAttribute("empleado",empleadoService.getListaEmpleado());
		return "redirect:/gestionDatos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoEmpleadoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		model.addAttribute("empleado", empleadoService.getEmpleado());
		return "nuevo_empleado";	
	}
	
	
	@PostMapping("/guardar")
	public String getGuardarEmpleado(@Valid @ModelAttribute("empleado")Empleado emp, BindingResult result,Model model){
		boolean edicion = false;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("empleado",emp);
			return "nuevo_empleado";
		}
		empleadoService.guardar(emp);
		return "redirect:/gestionDatos";
	}
	
	
	@GetMapping("/modificar/{id}")
	public String getModificarEmpleadoPage(Model model, @PathVariable(value="id")Long id){
		boolean edicion = true;
		Empleado empleadoEncontrado = empleadoService.buscar(id);
		model.addAttribute("empleado", empleadoEncontrado);
		model.addAttribute("edicion", edicion);	
		return "nuevo_empleado";
	}
	
	@PostMapping("/modificar")
	public String modificarEmpleado(@Valid @ModelAttribute("empleado")Empleado emp, BindingResult result,Model model) {
		boolean edicion = true;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("empleado",emp);
			return "nuevo_empleado";
		}
		empleadoService.modificar(emp);
		return "redirect:/gestionDatos";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable(value="id")Long id){		
		empleadoService.eliminar(empleadoService.buscar(id));
		return "redirect:/gestionDatos";
	}
}