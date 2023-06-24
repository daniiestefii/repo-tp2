package ar.edu.unju.fi.service.imp;

import java.util.List;

import ar.edu.unju.fi.controller.entity.*;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ConsejoServiceImp implements IConsejoService {
    @Autowired
    private IConsejoRepository consejoRepository;
    @Autowired
    private Consejo consejo;

    @Override
    public List<Consejo> getListaConsejos() {
        return consejoRepository.findByEstado(true);
    }

    @Override
    public void guardar(@Valid Consejo consejo) {
        consejo.setEstado(true);
        consejoRepository.save(consejo);

    }

    @Override
    public Consejo buscar(long id) {
        return consejoRepository.findById(id).get();
    }

    @Override
    public void modificar(Consejo consejo) {
        consejoRepository.save(consejo);}

    @Override
    public void eliminar(Consejo consejoEncontrado) {
        consejoEncontrado.setEstado(false);
        consejoRepository.save(consejoEncontrado);
    }

    @Override
    public Consejo getConsejo() {
        return consejo;
    }


}