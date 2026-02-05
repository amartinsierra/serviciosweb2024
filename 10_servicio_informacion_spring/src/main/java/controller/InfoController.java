package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Ficha;

@RestController
public class InfoController {
	private static final String EXPLICACION_SPRING = "Spring es un framework de Java que aporta inversión de control "
			+ "e inyección de dependencias, junto con un ecosistema de módulos como Spring Boot y Spring MVC "
			+ "para crear aplicaciones web y microservicios de forma rápida y consistente.";

	@GetMapping(value="/info",produces = MediaType.APPLICATION_JSON_VALUE)
	public Ficha info() {
		return new Ficha("pc",700,"Informática");
	}

	@GetMapping(value="/spring", produces = MediaType.TEXT_PLAIN_VALUE)
	public String queEsSpring() {
		return EXPLICACION_SPRING;
	}
}
