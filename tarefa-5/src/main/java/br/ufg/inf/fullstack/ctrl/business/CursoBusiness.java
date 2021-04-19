package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.model.entities.Curso;
import br.ufg.inf.fullstack.model.repositories.CursoRepository;

@Service
public class CursoBusiness {

	@Autowired
	private CursoRepository repository;

	public List<Curso> findAll() {
		return repository.findAll();
	}

	public Curso findById(Integer id) {
		Optional<Curso> retorno = repository.findById(id);
		return retorno.get();
	}

	public Curso insert(Curso curso) {
		return repository.save(curso);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Curso update(Curso cursoUpd) {
		Curso curso = repository.findById(cursoUpd.getIdCurso()).get();
		curso.setNmCurso(cursoUpd.getNmCurso());
		return repository.save(curso);

	}
}
