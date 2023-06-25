package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Noticia;
import ar.edu.unju.fi.repository.INoticiaRepository;
import ar.edu.unju.fi.service.INoticiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("NoticiaServiceImp")
public class NoticiaServiceImp implements INoticiaService{
	
	@Autowired
	private INoticiaRepository listaNoticia;
	@Autowired
	private Noticia noticia;
	/** devuelve todos las entidades de una tabla que tengan
	 * el estado en true*/
	public List<Noticia> getListaNoticias(){
		return listaNoticia.findByEstado(true);
	}
	/** guarda un objeto que es recibido como parametro en la tabla
     * pero antes de eso su estado cambia a true*/
	public void guardar(Noticia noticia) {
		noticia.setEstado(true);
		listaNoticia.save(noticia);
	}
	/**
     * busca un objeto segun un id que llega como parametro
     */
	public Noticia buscar(Long id) {
		return listaNoticia.findById(id).get();
	}
	/**
     * modifica un objeto que llega como parametro en la tabla 
     * de la base de datos, si existe en la tabla es modificado.
     */
	public void modificar(Noticia noticia) {
		listaNoticia.save(noticia);
	}
	/**
     * cambia el estado de un objeto que llega como parametro como
     * referencia para la tabla de la base de datos
     */
	public void eliminar(Noticia noticiaEncontrado) {
		noticiaEncontrado.setEstado(false);
		listaNoticia.save(noticiaEncontrado);
	}
	/**
     * devuelve un objeto
     */
	public Noticia getNoticia(){
	  return noticia;
	}
}