package init.utilidades;

import org.springframework.stereotype.Component;

import init.model.Book;
import init.model.LibroJson;

@Component
public class Mapeador {
	public Book jsonToBook(LibroJson libro) {
		int clasificacion=getClasificacion(libro.getPaginas());
		return new Book(libro.getTitulo(),libro.getTemaJson().getNombreTema(),libro.getPrecio(),clasificacion);		
	}
	private int getClasificacion(int paginas) {
		if(paginas>0 && paginas<=100) {
			return 1;
		}
		else if(paginas>100 && paginas<=200) {
			return 2;
		}
		else {
			return 3;
		}
	}
}
