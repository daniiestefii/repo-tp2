package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Autor;
import ar.edu.unju.fi.controller.entity.Categoria;
import ar.edu.unju.fi.controller.entity.Consejo;
import ar.edu.unju.fi.controller.entity.Producto;
import jakarta.validation.Valid;

import java.util.List;

public interface IConsejoService {
    /**
     * @method Devuelve una lista de todos los Consejos
     */
    List<Consejo> getListaConsejos();
    /**
     * @method Guarda un nuevo Consejo
     */
    void guardar(@Valid Consejo consejo);
    /**
     * @method  Devuelve un Consejo cuyo id coincide con el parámetro id.
     */
    Consejo buscar(long id);
    /**
     * @method Modifica un Consejo existente
     */
    void modificar(Consejo consejo);
    /**
     * @method Elimina una consejo existente
     */
    void eliminar(Consejo consejoEncontrado);
    /**
     * @method Devuelve un nuevo objeto Consejo
     */
    Consejo getConsejo();
    List<Consejo> getListaConsejosFiltrados(Autor autor, boolean estado);


}
