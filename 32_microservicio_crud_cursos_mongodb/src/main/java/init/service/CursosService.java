package init.service;

import java.util.List;

import init.model.Curso;

public interface CursosService {
	//no se adminten cursos con el mismo nombre
	boolean guardarCurso(Curso curso);
	
	List<Curso> cursosPorDuracionMaxima(int max);
	
	List<Curso> catalogo();
	//si el curso no existe devuelve falso
	boolean eliminarCurso(String curso);
}
