package init.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import init.model.Book;
import init.model.LibroJson;
import init.utilidades.Mapeador;
@Service
public class BooksServiceImpl implements BooksService {
	String url="http://servicio-libros/libros";
	RestClient restClient;
	Mapeador mapeador;

	public BooksServiceImpl(RestClient restClient, Mapeador mapeador) {
		this.restClient = restClient;
		this.mapeador=mapeador;
	} 
	@Override
	public List<Book> buscarRangoPrecios(double min, double max) {
		return 
			Arrays.stream(restClient
							.get()
							.uri(url+"/catalogo")
							.retrieve()
							.body(LibroJson[].class))
									.map(l->mapeador.jsonToBook(l))
									.filter(l->l.getPrecio()>=min && l.getPrecio()<=max)
									.toList(); 
	}

}
