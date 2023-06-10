package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.model.Consejo;
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.service.IConsejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsejoServiceImp implements IConsejoService {
    @Autowired
    private ListaConsejo listaConsejo;
    @Autowired
    private Consejo consejo;


    @Override
    public List<Consejo> getListaConsejo() {
        return listaConsejo.getConsejos();
    }

    @Override
    public void guardar(Consejo consejo) {
        listaConsejo.getConsejos().add(consejo);
    }

    @Override
    public Consejo getBy(String titulo) {
        Consejo consejoencontrado = new Consejo();
        boolean edicion = true;
        for (Consejo conse : listaConsejo.getConsejos()) {
            if (conse.getTitulo().equals(titulo)) {
                consejoencontrado = conse;
                break;
            }
        }
        return consejoencontrado;
    }

    @Override
    public void modificar(Consejo consejo) {
        for (Consejo conse : listaConsejo.getConsejos()) {
            if (conse.getTitulo().equals(consejo.getTitulo())) {
                conse.setTexto(consejo.getTexto());
            }
        }

    }

    @Override
    public void eliminar(Consejo consejo) {
        listaConsejo.getConsejos().remove(consejo);
    }

    @Override
    public Consejo getConsejo() {
        return consejo;
    }
}
