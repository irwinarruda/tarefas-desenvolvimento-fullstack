package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.model.entities.Disciplina;
import br.ufg.inf.fullstack.model.repositories.DisciplinaRepository;

@Service
public class DisciplinaBusiness {

	@Autowired
	private DisciplinaRepository repository;
	
	public List<Disciplina> findAll(){
		return repository.findAll();
	}
	
	public Disciplina findById(Integer id) {
		Optional<Disciplina> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Disciplina insert(Disciplina disciplina) {
		return repository.save(disciplina);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Disciplina update(Disciplina disciplina) {
		Disciplina disciplinaUpd = repository.findById(disciplina.getIdDisciplina()).get();
		disciplinaUpd.setCargaHoraria(disciplina.getCargaHoraria());
		disciplinaUpd.setNmDisciplina(disciplina.getNmDisciplina());
		return repository.save(disciplinaUpd);
		
	}
}
