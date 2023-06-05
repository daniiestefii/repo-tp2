package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.controller.model.Consejo;

@Component
public class ListaConsejo{
   private List<Consejo>consejos;

	/*
	 * Esta lista de consejos para la salud de las mascotas contiene objetos de la clase "Consejo".
	 */
   public ListaConsejo(){
	   consejos = new ArrayList<Consejo>();
	   consejos.add(new Consejo("Consejo de Salud para nuestra mascotas\r\n"
	   		+ "¿Son realmente tan necesarias la vacunación y la revacunación?","\r\n"
	   				+ "La vacunación de los animales de compañía es el método preventivo más adecuado para evitar la aparición de diversas enfermedades. Es imprescindible respetar el calendario de vacunaciones propuesto por el veterinario ya que tiene una importancia fundamental para la consecución de una salud plena. La vacunación o inmunización activa es el procedimiento preventivo por excelencia; desgraciadamente no existen vacunas contra todas las patologías de nuestros animales de compañía, pero si disponemos de un gran número de ellas para prevenir patologías de diversa gravedad. La vacunación es un procedimiento sencillo y eficaz. Mediante la aplicación de vacunas en nuestros compañeros hemos conseguido erradicar ciertas patologías que no sólo afectaban, por ejemplo, al perro, sino que a su vez hemos erradicado patologías que podrían afectar de forma muy grave al ser humano. Un dueño responsable debe pensar exclusivamente en el beneficio sanitario y no ver tras la vacunación solo el pago del servicio ofrecido por el veterinario. Las vacunas deben ser manejadas exclusivamente por los veterinarios, puesto que su preparación profesional y su experiencia les otorga plena capacidad para manejar las distintas estrategias de vacunación y adecuarlas a cada animal en concreto. Debemos revacunar a nuestro animal todos los años. Los cachorros deben revacunarse debido a la inmadurez de su sistema inmune y a las posibles interferencias con las defensas de la madre. La revacunación anual es imprescindible para asegurarnos una protección continuada y de alta efectividad durante toda la vida del animal. No pasa nada si la vacunación se retrasa unos días sobre la fecha prevista, pero si el retraso fuera prolongado, deberíamos consultar con el profesional la posibilidad de instaurar otro calendario de vacunaciones."));
	   consejos.add(new Consejo("¿Cuales son las principales enfermedades del perro que se evitan con la vacunación?","Moquillo:\r\n"
	   		+ "Es una enfermedad muy contagiosa producida por un virus, que afecta principalmente a cachorros no vacunados. Según el tipo de infección, el animal puede morir o quedar con lesiones permanentes; el problema suele comenzar con fiebre, ojos y nariz con secreciones, tos, diarrea y seguir con deshidratación, pérdida de peso y síntomas nerviosos."));
   }

public List<Consejo> getConsejos() {
	return consejos;
}

public void setConsejos(List<Consejo> consejos) {
	this.consejos = consejos;
}
 
}