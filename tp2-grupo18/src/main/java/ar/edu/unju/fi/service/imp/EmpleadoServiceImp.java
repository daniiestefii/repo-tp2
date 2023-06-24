package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Empleado;
import ar.edu.unju.fi.repository.IEmpleadoRepository;
import ar.edu.unju.fi.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("EmpleadoServiceImp")
public class EmpleadoServiceImp implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;
    @Autowired
    private Empleado empleado;
    @Override
    public List<Empleado> getListaEmpleado() {
        return empleadoRepository.findByEstado(true);
    }

    @Override
    public void guardar(Empleado empleado) {
    	empleado.setEstado(true);
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado buscar(Long id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public void modificar(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void eliminar(Empleado empleado) {
        empleado.setEstado(false);
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado getEmpleado() {
        return empleado;
    }
}
