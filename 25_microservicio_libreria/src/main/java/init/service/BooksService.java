package init.service;

import java.util.List;

import init.model.Book;

public interface BooksService {
	List<Book> buscarRangoPrecios(double min, double max);
}
