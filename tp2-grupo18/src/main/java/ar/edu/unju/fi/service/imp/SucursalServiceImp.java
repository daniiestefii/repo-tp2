package ar.edu.unju.fi.service.imp;

import java.util.List;

import ar.edu.unju.fi.controller.entity.Provincia;
import ar.edu.unju.fi.controller.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.entity.Categoria;
import ar.edu.unju.fi.controller.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Service
public class SucursalServiceImp implements ISucursalService {
	@Autowired
	private ISucursalRepository sucursalRepository;
	@Autowired
	private Sucursal sucursal;

	@Autowired
	private IProvinciaService provinciaService;


	@Override
	public List<Sucursal> getListaSucursales() {
		return sucursalRepository.findByEstado(true);
	}

	@Override
	public void guardar(Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);

	}

	@Override
	public Sucursal buscar(long id) {
		return sucursalRepository.findById(id).get();
	}

	@Override
	public void modificar(Sucursal sucursal) {
		//sucursal.setEstado(true);
		sucursalRepository.save(sucursal);}

	@Override
	public void eliminar(Sucursal sucursalEncontrado) {
		sucursalEncontrado.setEstado(false);
		sucursalRepository.save(sucursalEncontrado);
	}

	@Override
	public Sucursal getSucursal() {

		return sucursal;
	}

	@Override
	public List<Sucursal> getListaSucursalesFiltrados(Provincia provincia, boolean estado) {
		return null;
	}



}