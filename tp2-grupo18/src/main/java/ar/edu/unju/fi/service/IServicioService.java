package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Servicio;

import java.util.List;

public interface IServicioService {
    /**
     * @method Devuelve una lista de todos los servicios
     */
    List<Servicio> getListaServicio();
    /**
     * @method Guarda una nuevo servicio
     */
    void guardar(Servicio servicio);
    /**
     * @method  Devuelve el servicio cuyo nombre coincide con el parámetro de servicio.
     */
    Servicio buscar(Long id);
    /**
     * @method Modifica un Servicio existente
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
    
    List<Servicio> getListaServicioFiltrados(String dia);
}
