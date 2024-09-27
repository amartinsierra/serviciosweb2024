package controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Curso;
import service.CursosService;

@RestController
public class CursosController {
	CursosService cursosService;

	public CursosController(CursosService cursosService) {
		this.cursosService = cursosService;
	}
	
	@PostMapping(value="alta", consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
	public String alta(@RequestBody Curso curso) {
		return String.valueOf(cursosService.alta(curso));
	}
	@DeleteMapping(value="eliminar/{nombre}")
	public void eliminar(@PathVariable("nombre") String nombre) {
		cursosService.eliminar(nombre);
	}
	@PutMapping(value="actualizar",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Curso curso) {
		cursosService.modificarDatos(curso);
	}
	@GetMapping(value="buscar/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarPorNombre(@PathVariable("nombre") String nombre) {
		return cursosService.buscarCurso(nombre);
	}
	@GetMapping(value="recuperartodos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> recuperarTodos(){
		return cursosService.devuelveCursos();
	}
	
}
