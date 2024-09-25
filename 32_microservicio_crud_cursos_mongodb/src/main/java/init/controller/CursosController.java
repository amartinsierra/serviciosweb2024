package init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import init.model.Curso;
import init.service.CursosService;

@RestController
public class CursosController {
	CursosService cursosService;

	public CursosController(CursosService cursosService) {
		super();
		this.cursosService = cursosService;
	}
	@GetMapping(value="catalogo",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> catalogo(){
		return cursosService.catalogo();
	}
	@PostMapping(value="alta",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> nuevoCurso(Curso curso){
		if(cursosService.guardarCurso(curso)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
