package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.dao.CursosDao;
import init.model.Curso;
@Service
public class CursosServiceImpl implements CursosService {
	
	CursosDao cursosDao;
	

	public CursosServiceImpl(CursosDao cursos) {
		super();
		this.cursosDao = cursos;
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		if(cursosDao.findByCurso(curso.getCurso())!=null) {
			return false;
		}
		cursosDao.save(curso);
		return true;
	}

	@Override
	public List<Curso> cursosPorDuracionMaxima(int max) {
		return cursosDao.findByDuracionMax(max);
	}

	@Override
	public List<Curso> catalogo() {
		return cursosDao.findAll();
	}

	@Override
	public boolean eliminarCurso(String curso) {
		if(cursosDao.findByCurso(curso)==null) {
			return false;
		}
		cursosDao.deleteByCurso(curso);
		return true;
	}

}
