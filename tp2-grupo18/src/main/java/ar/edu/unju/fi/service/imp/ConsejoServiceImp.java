package ar.edu.unju.fi.service.imp;

import java.util.List;

import ar.edu.unju.fi.controller.entity.Consejo;
import ar.edu.unju.fi.controller.entity.Autor;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConsejoServiceImp implements IConsejoService {

    @Autowired
    private IConsejoRepository consejoRepository;

    @Autowired
    private Consejo consejo;

    /**
     * Retorna una lista de consejos activos.
     *
     * @return Lista de consejos activos.
     */
    @Override
    public List<Consejo> getListaConsejos() {
        return consejoRepository.findByEstado(true);
    }

    /**
     * Guarda un consejo.
     *
     * @param consejo El consejo a guardar.
     */
    @Override
    public void guardar(Consejo consejo) {
        consejo.setEstado(true);
        consejoRepository.save(consejo);
    }

    /**
     * Busca un consejo por su ID.
     *
     * @param id ID del consejo a buscar.
     * @return El consejo encontrado.
     */
    @Override
    public Consejo buscar(long id) {
        return consejoRepository.findById(id).get();
    }

    /**
     * Modifica un consejo existente.
     *
     * @param consejo El consejo a modificar.
     */
    @Override
    public void modificar(Consejo consejo) {
        consejoRepository.save(consejo);
    }

    /**
     * Elimina un consejo.
     *
     * @param consejoEncontrado El consejo a eliminar.
     */
    @Override
    public void eliminar(Consejo consejoEncontrado) {
        consejoEncontrado.setEstado(false);
        consejoRepository.save(consejoEncontrado);
    }

    /**
     * Retorna un objeto consejo.
     *
     * @return El objeto consejo.
     */
    @Override
    public Consejo getConsejo() {
        return consejo;
    }

    /**
     * Retorna una lista de consejos filtrados por autor y estado.
     *
     * @param autor  El autor utilizado para filtrar los consejos.
     * @param estado El estado utilizado para filtrar los consejos.
     * @return Lista de consejos filtrados por autor y estado.
     */
    @Override
    public List<Consejo> getListaConsejosFiltrados(Autor autor, boolean estado) {
        return consejoRepository.findByAutorAndEstado(autor, estado);
    }
}
