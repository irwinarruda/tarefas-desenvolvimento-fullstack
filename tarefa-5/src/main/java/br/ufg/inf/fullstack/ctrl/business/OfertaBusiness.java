package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.model.entities.Oferta;
import br.ufg.inf.fullstack.model.repositories.OfertaRepository;

@Service
public class OfertaBusiness {

	@Autowired
	private OfertaRepository repository;

	public List<Oferta> findAll() {
		return repository.findAll();
	}

	public Oferta findById(Integer id) {
		Optional<Oferta> retorno = repository.findById(id);
		return retorno.get();
	}

	public Oferta insert(Oferta oferta) {
		return repository.save(oferta);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Oferta update(Oferta ofertaUpd) {
		Oferta oferta = repository.findById(ofertaUpd.getIdOferta()).get();
		oferta.setDia(ofertaUpd.getDia());
		oferta.setDisciplina(ofertaUpd.getDisciplina());
		oferta.setDtFim(ofertaUpd.getDtFim());
		oferta.setDtInicio(ofertaUpd.getDtInicio());
		oferta.setHora(ofertaUpd.getHora());
		oferta.setProfessor(ofertaUpd.getProfessor());
		return repository.save(oferta);

	}
}
