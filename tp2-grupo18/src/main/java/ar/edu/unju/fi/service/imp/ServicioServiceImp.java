package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.model.Servicio;
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

    @Override
    public List<Servicio> getListaServicio() { return listaServicio.getServicios();}

    @Override
    public void guardar(Servicio servicio) {
        listaServicio.getServicios().add(servicio);
    }

    @Override
    public Servicio buscar(String nombre) {
        Servicio servicioEncontrado = null;
        for(Servicio servi: listaServicio.getServicios()) {
            if(servi.getNombre().equals(nombre)) {
                servicioEncontrado = servi;
                break;
            }
        }
        return servicioEncontrado;
    }

    @Override
    public void modificar(Servicio servicio) {
        for(Servicio servi : listaServicio.getServicios()) {
            if(servi.getNombre().equals(servicio.getNombre())) {
                servi.setDia(servicio.getDia());
                servi.setHorario(servicio.getHorario());
                break;
            }
        }

    }

    @Override
    public void eliminar(Servicio servicioEncontrado) {
        listaServicio.getServicios().remove(servicioEncontrado);
    }

    @Override
    public Servicio getServicio() {
        return servicio;
    }
}
