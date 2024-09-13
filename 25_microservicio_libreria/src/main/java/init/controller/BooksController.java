package init.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import init.model.Book;
import init.service.BooksService;

@CrossOrigin("*")
@RestController
public class BooksController {
	BooksService libreriaService;

	public BooksController(BooksService libreriaService) {
		super();
		this.libreriaService = libreriaService;
	}
	
	@GetMapping(value="librosPorPrecio/{precioMinimo}/{precioMaximo}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Book>buscarPorPrecio(@PathVariable("precioMinimo") double precioMinimo,
										@PathVariable("precioMaximo") double precioMaximo){
		return libreriaService.buscarRangoPrecios(precioMinimo, precioMaximo);
	} 
}