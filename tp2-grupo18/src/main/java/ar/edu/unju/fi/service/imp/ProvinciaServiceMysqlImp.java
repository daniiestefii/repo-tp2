package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("provinciaServiceMysql")
public class ProvinciaServiceMysqlImp implements IProvinciaService {

    @Autowired
    private IProvinciaRepository provinciaRepository;
    @Override
    public List<Provincia> getListaProvincia() {
        return provinciaRepository.findByEstado(true);
    }

    @Override
    public void guardar(Provincia provincia) {
        provinciaRepository.save(provincia);
    }

    @Override
    public Provincia buscar(Long id) {
        return provinciaRepository.findById(id).get();
    }

    @Override
    public void modificar(Provincia provincia) {
        provinciaRepository.save(provincia);
    }

    @Override
    public void eliminar(Provincia provincia) {
        provincia.setEstado(false);
        provinciaRepository.save(provincia);
    }

    @Override
    public Provincia getProvincia() {
        return null;
    }
}
