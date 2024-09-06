package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.PaisesService;
@CrossOrigin("*")
@RestController
public class PaisesController {

	PaisesService paisesService;

	public PaisesController(PaisesService paisesService) {
		super();
		this.paisesService = paisesService;
	}
	
	@GetMapping(value="continentes",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> continentes(){
		try {
			List<String> continentes= paisesService.continentes();
			return new ResponseEntity<>(continentes,HttpStatus.OK);
		}catch(RuntimeException ex) {
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@GetMapping(value="paises/{continente}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pais>> paises(@PathVariable("continente") String continente){
		try {
			List<Pais> paises= paisesService.paisesPorContinente(continente);
			return new ResponseEntity<>(paises,HttpStatus.OK);
		}catch(RuntimeException ex) {
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
}
