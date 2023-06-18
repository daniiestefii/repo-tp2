package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.entity.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Service
public class SucursalServiceImp implements ISucursalService {

	@Autowired
	private Sucursal sucursal;
	@Autowired
	private ListaSucursal listaSucursal;
	/**
     * @method metodo que devuelve una lista sucursal
     */
	@Override
	public List<Sucursal> getListaSucursal() {
		return listaSucursal.getSucursales();
	}
	/**
     * @method guarda un objeto sucursal que viene por parametro a la lista
     */
	@Override
	public void guardar(@Valid Sucursal sucursal) {
		listaSucursal.getSucursales().add(sucursal);
		
	}
	/**
     * @method busca por el nombre de parametro recorriendo la lista y devolviendo
     * el objeto si se encuentra o un valor nulo
     */
	@Override
	public Sucursal buscar(String nombre) {
		Sucursal sucursalEncontrado = null;
		for(Sucursal sucu: listaSucursal.getSucursales()) {
			if(sucu.getNombre().equals(nombre)) {
				sucursalEncontrado = sucu;
				break;
			}
		}
		return sucursalEncontrado;
	}
	/**
     * @method modifica un cierto objeto sucursal de la lista dependiendo
     * si tiene el mismo nombre del objeto que viene por parametro
     */
	@Override
	public void modificar(Sucursal sucursal) {
		for(Sucursal s : listaSucursal.getSucursales()) {
			if(s.getNombre().equals(sucursal.getNombre())) {
				s.setNombre(sucursal.getNombre());
				s.setLugar(sucursal.getLugar());
				s.setTelefono(sucursal.getTelefono());
				s.setDia(sucursal.getDia());
				s.setHorario(sucursal.getHorario());
				s.setGmail(sucursal.getGmail());
				s.setFechainicio(sucursal.getFechainicio());
				break;
			}
		}
	}
	/**
     * @method elimina un objeto dentro de la lista que
     * llega como parametro
     */
	@Override
	public void eliminar(Sucursal sucursalEncontrado) {
		listaSucursal.getSucursales().remove(sucursalEncontrado);
	}
	/**
     * @method Devuelve un objeto sucursal
     */
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}

}
