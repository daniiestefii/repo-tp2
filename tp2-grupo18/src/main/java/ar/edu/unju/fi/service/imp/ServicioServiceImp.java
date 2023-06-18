package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Servicio;
import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioServiceImp implements IServicioService {
    @Autowired
    private Servicio servicio;
    @Autowired
    private ListaServicio listaServicio;
    /**
     * @method Devuelve una lista de tipo Servicio
     *
     **/
    @Override
    public List<Servicio> getListaServicio() { return listaServicio.getServicios();}
    /**
     * @method guarda un objeto servicio que viene por parametro a la lista
     */
    @Override
    public void guardar(Servicio servicio) {
        listaServicio.getServicios().add(servicio);
    }
    /**
     * @method busca por el nombre de parametro recorriendo la lista y devolviendo
     * el objeto si se encuentra o un valor nulo
     */
    @Override
    public Servicio buscar(String dia) {
        Servicio servicioEncontrado = null;
        for(Servicio servi: listaServicio.getServicios()) {
            if(servi.getDia().equals(dia)) {
                servicioEncontrado = servi;
                break;
            }
        }
        return servicioEncontrado;
    }
    /**
     * @method modifica un cierto objeto servicio de la lista dependiendo
     * si tiene el mismo nombre del objeto que viene por parametro
     */
    @Override
    public void modificar(Servicio servicio) {
        for(Servicio servi : listaServicio.getServicios()) {
            if(servi.getDia().equals(servicio.getDia())) {
                servi.setNombre(servicio.getNombre());
                servi.setHorario(servicio.getHorario());
                break;
            }
        }

    }
    /**
     * @method elimina un objeto dentro de la lista que
     * llega como parametro
     */
    @Override
    public void eliminar(Servicio servicioEncontrado) {
        listaServicio.getServicios().remove(servicioEncontrado);
    }
    /**
     * @method Devuelve un objeto servicio
     */
    @Override
    public Servicio getServicios() {
        return servicio;
    }
}
