package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.controller.model.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ListaProducto listaPro;
	
	
	private Producto producto;
	
	@GetMapping("/listadoProductos")
	public String getProductoPage(Model model) {
		for (Producto i : listaPro.getProductos()) {
            i.setPrecio(i.calcularDescuento());
        }
		model.addAttribute("producto",listaPro.getProductos());
		return "Productos";
	}
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		model.addAttribute("producto", new Producto("",0,0,"",0));
		return "nuevo_producto"; 
	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarProducto(@Valid @ModelAttribute("producto")Producto prod, BindingResult result) {
		ModelAndView mav = new ModelAndView("Productos");
		if(result.hasErrors()){
			mav.setViewName("nuevo_producto");
			mav.addObject("producto",prod);
			return mav;
		}
		listaPro.getProductos().add(prod);
		mav.addObject("producto",listaPro.getProductos());
		return mav;
	}
}