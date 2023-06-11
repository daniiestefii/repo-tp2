package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.model.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Service
public class SucursalServiceImp implements ISucursalService {

	@Autowired
	private Sucursal sucursal;
	@Autowired
	private ListaSucursal listaSucursal;
	@Override
	public List<Sucursal> getListaSucursal() {
		return listaSucursal.getSucursales();
	}

	@Override
	public void guardar(@Valid Sucursal sucursal) {
		listaSucursal.getSucursales().add(sucursal);
		
	}

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

	@Override
	public void eliminar(Sucursal sucursalEncontrado) {
		listaSucursal.getSucursales().remove(sucursalEncontrado);
	}

	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}

}
