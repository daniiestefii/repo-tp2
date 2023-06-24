package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.controller.entity.Noticia;

@Component
public class ListaNoticia{
   private List<Noticia>noticias;
   
   public ListaNoticia() {
	   noticias = new ArrayList<Noticia>();
	   
   }

public List<Noticia> getNoticias() {
	return noticias;
}

public void setNoticias(List<Noticia> noticias) {
	this.noticias = noticias;
}
   

}