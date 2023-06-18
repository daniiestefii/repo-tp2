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
	   noticias.add(new Noticia("CONSEJOS VETERINARIOS","Con el fin de dar la atención que un animal requiere es importante que cubramos todas sus necesidades básicas, debemos proveer un sitio adecuado para que descanse protegido de inclemencias climáticas y que mantenga una temperatura adecuada.\r\n"
	   		+ "La alimentación de nuestra mascota es la base para resguardar su salud, es importante darle una dieta de alta calidad, según la recomendación que haga el médico veterinario de nuestra confianza.\r\n"
	   		+ "Debemos recordar que nuestra mascota es un ser vivo y como tal requiere socializar con otros de su especie y con seres humanos. Debemos dedicar tiempo para acariciarlo, jugar con él, ejercitarlo y llevarlo a pasear.\r\n"
	   		+ "Es importante que nuestra mascota esté saludable, para ello debemos mantenerlo limpio, bañarlo frecuentemente, recoger sus desechos, llevarlo a cortar el pelo en los animales que así lo requieren y por supuesto llevarlo de forma periódica al médico veterinario.\r\n"
	   		+ "Los cuidados veterinarios básicos incluyen control de parásitos, con el fin de que la mascota mantenga su buena salud y no se afecte la salud de nosotros, al igual que las personas ellos requieren vacunas, cuidado dental y programas médicos dependiendo de la edad que tengan, tu médico veterinario te hará las recomendaciones del caso, por eso debés llevar a tu mascota con él al menos 1 vez al año y en algunos casos se requieren visitas más frecuentes."));
	   noticias.add(new Noticia("IMPORTANCIA DE EVITAR QUE NUESTRAS MASCOTAS SALGAN SOLAS DE CASA","Cuando una persona decide hacerse cargo de una mascota, debe saber que ha encontrado una gran compañía, pero también ha adquirido una gran responsabilidad. Una de estas responsabilidades, que viene dada por la ley 7451 y 2391, es mantener la mascota en condiciones óptimas que resguarden su bienestar y eviten riesgos para personas y otros animales.\r\n"
	   		+ "\r\n"
	   		+ "Hay varias razones por las cuales nuestra mascota nunca debe salir sin supervisión:\r\n"
	   		+ "\r\n"
	   		+ "Hay animales que al salir y estar en contacto con otros de su especie, generan mucho ruido, especialmente en las noches, lo cual podría provocar molestias de los vecinos.\r\n"
	   		+ "Los perros y gatos en la calle se ven expuestos a muchos peligros, como lo son atropellos, envenenamientos, agresiones de parte de personas u otros animales.\r\n"
	   		+ "Existe riesgo de que el animal enferme al estar en contacto con otros animales que no están en óptimas condiciones de salud.\r\n"
	   		+ "Los animales en la calle buscarán defecar en jardines, parques, aceras y más, lo cual genera contaminación y el riesgo de transmisión de enfermedades graves, especialmente a los niños y personas con sistemas inmunológicos debilitados.\r\n"
	   		+ "Cuando tenemos una mascota agresiva y esta escapa de la casa, puede suponer un riesgo muy alto para las personas, ya que les puede generar lesiones y eso nos traerá prob lemas desde el punto de vista legal. La mascota se podrá extraviar o ser robada."));
   }

public List<Noticia> getNoticias() {
	return noticias;
}

public void setNoticias(List<Noticia> noticias) {
	this.noticias = noticias;
}
   

}