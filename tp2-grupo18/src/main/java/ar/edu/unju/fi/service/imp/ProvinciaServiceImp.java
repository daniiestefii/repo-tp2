package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaServiceImp implements IProvinciaService {

    @Autowired
    private IProvinciaRepository provinciaRepository;

    @Autowired
    private Provincia provincia;

    /**
     * Retorna una lista de provincias activas.
     *
     * @return Lista de provincias activas.
     */
    @Override
    public List<Provincia> getListaProvincias() {
        return provinciaRepository.findByEstado(true);
    }

    /**
     * Guarda una provincia.
     *
     * @param provincia La provincia a guardar.
     */
    @Override
    public void guardar(Provincia provincia) {
        provincia.setEstado(true);
        provinciaRepository.save(provincia);
    }

    /**
     * Busca una provincia por su ID.
     *
     * @param id ID de la provincia a buscar.
     * @return La provincia encontrada.
     */
    @Override
    public Provincia buscar(Long id) {
        return provinciaRepository.findById(id).get();
    }

    /**
     * Modifica una provincia existente.
     *
     * @param provincia La provincia a modificar.
     */
    @Override
    public void modificar(Provincia provincia) {
        provinciaRepository.save(provincia);
    }

    /**
     * Elimina una provincia.
     *
     * @param provincia La provincia a eliminar.
     */
    @Override
    public void eliminar(Provincia provincia) {
        provincia.setEstado(false);
        provinciaRepository.save(provincia);
    }

    /**
     * Retorna un objeto provincia.
     *
     * @return El objeto provincia.
     */
    @Override
    public Provincia getProvincia() {
        return provincia;
    }
}
