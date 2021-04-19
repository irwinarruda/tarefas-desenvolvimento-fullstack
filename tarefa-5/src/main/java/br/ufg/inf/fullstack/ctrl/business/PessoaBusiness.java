package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.model.entities.Pessoa;
import br.ufg.inf.fullstack.model.repositories.PessoaRepository;

@Service
public class PessoaBusiness {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
	
	public Pessoa findById(Integer id) {
		Optional<Pessoa> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Pessoa insert(Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Pessoa update(Pessoa pessoa) {
		Pessoa pessoaUpd = repository.findById(pessoa.getIdPessoa()).get();
		pessoaUpd.setCpf(pessoa.getCpf());
		pessoaUpd.setNmPessoa(pessoa.getNmPessoa());
		pessoaUpd.setDtNascimento(pessoa.getDtNascimento());
		return repository.save(pessoaUpd);
		
	}
}
