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
    /** devuelve todos las entidades de una tabla que tengan
	 * el estado en true*/
    @Override
    public List<Empleado> getListaEmpleado() {
        return empleadoRepository.findByEstado(true);
    }
    /** guarda un objeto que es recibido como parametro en la tabla
     * pero antes de eso su estado cambia a true*/
    @Override
    public void guardar(Empleado empleado) {
    	empleado.setEstado(true);
        empleadoRepository.save(empleado);
    }
    /**
     *  busca un objeto segun un id que llega como parametro
     */
    @Override
    public Empleado buscar(Long id) {
        return empleadoRepository.findById(id).get();
    }
    /**
     * modifica un objeto que llega como parametro en la tabla 
     * de la base de datos, si existe en la tabla es modificado.
     */
    @Override
    public void modificar(Empleado empleado) {
        empleadoRepository.save(empleado);
    }
    /**
     * cambia el estado de un objeto que llega como parametro como
     * referencia para la tabla de la base de datos
     */
    @Override
    public void eliminar(Empleado empleado) {
        empleado.setEstado(false);
        empleadoRepository.save(empleado);
    }
    /**
     * devuelve un objeto
     */
    @Override
    public Empleado getEmpleado() {
        return empleado;
    }
}
