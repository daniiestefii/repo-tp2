package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Categoria;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("CategoriaServiceImp")
public class CategoriaServiceImp implements ICategoriaService{

    @Autowired
    private ICategoriaRepository categoriaRepository;
    @Autowired
    private Categoria categoria;
    /** devuelve todos las entidades de una tabla que tengan
	 * el estado en true*/
    @Override
    public List<Categoria> getListaCategoria() {
        return categoriaRepository.findByEstado(true);
    }

    /** guarda un objeto que es recibido como parametro en la tabla
     * pero antes de eso su estado cambia a true*/
    @Override
    public void guardar(Categoria categoria) {
       categoria.setEstado(true);
       categoriaRepository.save(categoria);
    }

    /**
     *  busca un objeto segun un id que llega como parametro
     */
    @Override
    public Categoria buscar(long id) {
        return categoriaRepository.findById(id).get();
    }

    /**
     * modifica un objeto que llega como parametro en la tabla 
     * de la base de datos, si existe en la tabla es modificado.
     */
    @Override
    public void modificar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    /**
     * cambia el estado de un objeto que llega como parametro como
     * referencia para la tabla de la base de datos
     */
    @Override
    public void eliminar(Categoria categoria) {
        categoria.setEstado(false);
        categoriaRepository.save(categoria);
    }

    /**
     * devuelve un objeto
     */
    @Override
    public Categoria getCategoria() {
        return categoria;
    }
}
