package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Empleado;
import jakarta.validation.Valid;

import java.util.List;

public interface IEmpleadoService {
    /**
     * @method Devuelve una lista de todos los Empleados
     */
    List<Empleado> getListaEmpleado();
    /**
     * @method Guarda una nuevo Empleado
     */
    void guardar(@Valid Empleado empleado);
    /**
     * @method  Devuelve  el empleado cuyo id coincide con el parámetro id.
     */
    Empleado buscar(Long id);
    /**
     * @method Modifica un Empleado existente
     */
    void modificar(Empleado empleado);
    /**
     * @method Elimina un Empleado existente
     */
    void eliminar(Empleado empleadoEncontrado);
    /**
     * @method Devuelve un nuevo objeto empleado
     */
    Empleado getEmpleado();

}