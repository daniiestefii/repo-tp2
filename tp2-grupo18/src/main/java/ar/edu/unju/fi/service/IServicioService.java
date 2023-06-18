package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Servicio;
import jakarta.validation.Valid;

import java.util.List;

public interface IServicioService {
    /**
     * @method Devuelve una lista de todos las servicios
     */
    List<Servicio> getListaServicio();
    /**
     * @method Guarda una nuevo servicio
     */
    void guardar(@Valid Servicio servicio);
    /**
     * @method  Devuelve el servicio cuyo nombre coincide con el parámetro de servicio.
     */
    Servicio buscar(String dia);
    /**
     * @method Modifica una sucursal existente
     */
    void modificar(Servicio servicio);
    /**
     * @method Elimina un servicio existente
     */
    void eliminar(Servicio servicioEncontrado);
    /**
     * @method Devuelve un nuevo objeto servicio
     */
    Servicio getServicios();
}
