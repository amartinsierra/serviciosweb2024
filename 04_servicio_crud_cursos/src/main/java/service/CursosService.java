package service;

import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursosService {
	private static List<Curso> cursos=new ArrayList<>();
	public boolean alta(Curso curso) {
		if(buscarCurso(curso.getNombre())==null) {
			cursos.add(curso);
			return true;
		}
		return false;
		
	}
	public void eliminar(String nombre) {
		cursos.removeIf(c->c.getNombre().equals(nombre));
	}
	public void modificarDatos(Curso curso) {
		for(Curso c:cursos) {
			if(c.getNombre().equals(curso.getNombre())) {
				c.setArea(curso.getArea());
				c.setDuracion(curso.getDuracion());
				c.setPrecio(curso.getPrecio());
				break;// salimos del bucle for, ya que no necesitamos que se recorre más. ya hemos encontrado el curso y modicado.
			}
		}
	}

	public Curso buscarCurso(String nombre) {
		return 
				cursos.stream().
				filter(c->c.getNombre().equals(nombre))
				.findFirst()
				.orElse(null);
	}

	public List<Curso> devuelveCursos() {		
		return cursos;
	} 
}
