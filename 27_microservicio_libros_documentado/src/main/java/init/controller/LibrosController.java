package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import init.model.LibroDto;
import init.service.LibrosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class LibrosController {
	
	@Value("${eureka.instance.instance-id}")
	String instancia;	
	LibrosService librosService;
	public LibrosController(LibrosService librosService) {
		super();
		this.librosService = librosService;
	}
	@Operation(summary = "Busqueda de libros por tematica",description = "Devuelve todos los libros pertenecientes a la temática que se enviar como variable en URL")
	@GetMapping(value="buscarlibros/{tematica}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<LibroDto> buscarPorTema(@Parameter(description = "Tematica de búsqueda")@PathVariable("tematica") String tema){
		return librosService.buscarLibroPortema(tema);
	}
	@PostMapping(value="alta",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> altaLibro(@RequestBody LibroDto libro) {
		if(librosService.alta(libro)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	@GetMapping(value="buscar/{isbn}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibroDto> buscarPorIsbn(@PathVariable("isbn") int isbn){
		LibroDto libro=librosService.buscarLibroPorIsbn(isbn);
		if(libro!=null) {
			return new ResponseEntity<>(libro,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.CONFLICT);
	}
	@Operation(summary = "catalogo de libros", description = "Devuelve la lista de libros completa")
	@GetMapping(value="catalogo",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<LibroDto> buscarTodos(){
		System.out.println("Instancia: "+instancia);
		return librosService.recuperarTodos();
	}
}
