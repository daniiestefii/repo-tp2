package ar.edu.unju.fi;

import ar.edu.unju.fi.controller.entity.Provincia;
import ar.edu.unju.fi.service.IProvinciaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Tp2Grupo18ApplicationTests {
	@Autowired
	private IProvinciaService provinciaService;

	Provincia provincia;

	@Test
	void guardarProvincia() {
		provincia = new Provincia(null,"Tucuman",true);
		provinciaService.guardar(provincia);
		provincia = new Provincia(null,"Jujuy",true);
		provinciaService.guardar(provincia);
		provincia = new Provincia(null,"Salta",true);
		provinciaService.guardar(provincia);
        
	}

}
