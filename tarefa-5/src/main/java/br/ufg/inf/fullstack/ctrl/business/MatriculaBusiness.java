package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.model.entities.Matricula;
import br.ufg.inf.fullstack.model.repositories.MatriculaRepository;

@Service
public class MatriculaBusiness {

	@Autowired
	private MatriculaRepository repository;

	public List<Matricula> findAll() {
		return repository.findAll();
	}

	public Matricula findById(Integer id) {
		Optional<Matricula> retorno = repository.findById(id);
		return retorno.get();
	}

	public Matricula insert(Matricula matricula) {
		return repository.save(matricula);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Matricula update(Matricula matriculaUpd) {
		Matricula matricula = repository.findById(matriculaUpd.getIdMatricula()).get();
		matricula.setAluno(matriculaUpd.getAluno());
		matricula.setOferta(matriculaUpd.getOferta());
		return repository.save(matricula);
	}
}

