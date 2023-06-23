package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Empleado;
import ar.edu.unju.fi.controller.entity.Servicio;
import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioServiceImp implements IServicioService {
    @Autowired
    private Servicio servicio;
    @Autowired
    private IServicioRepository listaServicio;
    /**
     * @method Devuelve una lista de tipo Servicio
     *
     **/
    @Override
    public List<Servicio> getListaServicio() { 
    	
    	return listaServicio.findByEstado(true);
    
    }
    /**
     * @method guarda un objeto servicio que viene por parametro a la lista
     */
    @Override
    public void guardar(Servicio servicio) {
    	servicio.setEstado(true);
        listaServicio.save(servicio);
    }
    /**
     * @method busca por el nombre de parametro recorriendo la lista y devolviendo
     * el objeto si se encuentra o un valor nulo
     */
    @Override
    public Servicio buscar(Long id) {
        return listaServicio.findById(id).get();
      }
    /**
     * @method modifica un cierto objeto servicio de la lista dependiendo
     * si tiene el mismo nombre del objeto que viene por parametro
     */
    @Override
    public void modificar(Servicio servicio) {
         listaServicio.save(servicio);
    }
    /**
     * @method elimina un objeto dentro de la lista que
     * llega como parametro
     */
    @Override
    public void eliminar(Servicio servicioEncontrado) {
    	servicioEncontrado.setEstado(false);
        listaServicio.save(servicioEncontrado);
    }
    /**
     * @method Devuelve un objeto servicio
     */
    @Override
    public Servicio getServicios() {
        return servicio;
    }
    
      public List<Servicio> getListaServicioFiltrados(String dia) { 
    	  
    	  return listaServicio.findByDiaAndEstado(dia,true);
    }
}
