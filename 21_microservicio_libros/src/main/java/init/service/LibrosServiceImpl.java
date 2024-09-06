package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.dao.LibrosDao;
import init.model.LibroDto;
import init.utilidades.Mapeador;
@Service
public class LibrosServiceImpl implements LibrosService {
	
	LibrosDao librosDao;
	Mapeador mapeador;
	

	public LibrosServiceImpl(LibrosDao librosDao, Mapeador mapeador) {
		super();
		this.librosDao = librosDao;
		this.mapeador = mapeador;
	}

	@Override
	public boolean alta(LibroDto libro) {
		if(librosDao.findById(libro.getIsbn()).isEmpty()) {
			librosDao.save(mapeador.libroDtoToEntity(libro));
			return true;
		}
		return false;

	}

	@Override
	public List<LibroDto> buscarLibroPortema(String tema) {
		return librosDao.findByTema(tema)
				.stream()
				.map(l->mapeador.libroEntityToDto(l))
				.toList();
	}

	@Override
	public LibroDto buscarLibroPorIsbn(int isbn) {
		return librosDao.findById(isbn) //Optional<Libro>
				.map(l->mapeador.libroEntityToDto(l))//Optional<LibroDto>
				.orElse(null);
	}

}
