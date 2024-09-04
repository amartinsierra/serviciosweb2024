package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.ResultadoDto;
import service.BuscadorService;

@RestController
public class BuscadorController {
	
	@Autowired
	@Qualifier("buscadorEstandar")
	BuscadorService service;
	
	@GetMapping(value="buscar/{tematica}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ResultadoDto> buscarResultados(@PathVariable("tematica") String tematica) {
		return service.buscar(tematica);
		
	}
	
	@PostMapping(value="alta",produces=MediaType.TEXT_PLAIN_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String altaResultado(@RequestBody ResultadoDto resultado) {
		
		return String.valueOf(service.agregar(resultado));
	}
	
	
}
