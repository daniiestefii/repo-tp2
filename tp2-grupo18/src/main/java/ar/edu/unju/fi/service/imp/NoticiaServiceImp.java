package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Noticia;
import ar.edu.unju.fi.repository.INoticiaRepository;
import ar.edu.unju.fi.service.INoticiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaServiceImp implements INoticiaService {
	@Autowired
	private INoticiaRepository noticiaRepository;
	@Autowired
	private Noticia noticia;

	@Override
	public List<Noticia> getListaNoticias() {
		return noticiaRepository.findByEstado(true);
	}

	@Override
	public void guardar(@Valid Noticia noticia) {
		noticia.setEstado(true);
		noticiaRepository.save(noticia);

	}

	@Override
	public Noticia buscar(long id) {
		return noticiaRepository.findById(id).get();
	}

	@Override
	public void modificar(Noticia noticia) {
		noticiaRepository.save(noticia);}

	@Override
	public void eliminar(Noticia noticiaEncontrado) {
		noticiaEncontrado.setEstado(false);
		noticiaRepository.save(noticiaEncontrado);
	}

	@Override
	public Noticia getNoticia() {
		return noticia;
	}

}