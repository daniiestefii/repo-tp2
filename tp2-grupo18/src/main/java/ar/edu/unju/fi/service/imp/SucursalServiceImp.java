package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unju.fi.controller.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SucursalServiceImp implements ISucursalService {
	@Autowired
	private ISucursalRepository sucursalRepository;

	@Autowired
	private Sucursal sucursal;

	@Autowired
	private IProvinciaService provinciaService;


	/**
	 * Retorna una lista de sucursales activas.
	 *
	 * @return Lista de sucursales activas.
	 */
	@Override
	public List<Sucursal> getListaSucursales() {
		return sucursalRepository.findByEstado(true);
	}

	/**
	 * Guarda una sucursal.
	 *
	 * @param sucursal La sucursal a guardar.
	 */
	@Override
	public void guardar(Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);
	}

	/**
	 * Busca una sucursal por su ID.
	 *
	 * @param id ID de la sucursal a buscar.
	 * @return La sucursal encontrada.
	 */
	@Override
	public Sucursal buscar(long id) {
		return sucursalRepository.findById(id).get();
	}

	/**
	 * Modifica una sucursal existente.
	 *
	 * @param sucursal La sucursal a modificar.
	 */
	@Override
	public void modificar(Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}

	/**
	 * Elimina una sucursal.
	 *
	 * @param sucursalEncontrado La sucursal a eliminar.
	 */
	@Override
	public void eliminar(Sucursal sucursalEncontrado) {
		sucursalEncontrado.setEstado(false);
		sucursalRepository.save(sucursalEncontrado);
	}

	/**
	 * Retorna un objeto sucursal.
	 *
	 * @return El objeto sucursal.
	 */
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}

	/**
	 * Retorna una lista de sucursales filtradas por fecha.
	 *
	 * @param dia  La fecha de inicio para el filtrado.
	 * @param dia1 La fecha de fin para el filtrado.
	 * @return Lista de sucursales filtradas por fecha.
	 */
	@Override
	public List<Sucursal> getListaSucursalesFiltradosForFecha(String dia, String dia1) {
		LocalDate startDate = LocalDate.parse(dia);
		LocalDate endDate = LocalDate.parse(dia1);
		return sucursalRepository.findByDateBetween(startDate, endDate);
	}
}
