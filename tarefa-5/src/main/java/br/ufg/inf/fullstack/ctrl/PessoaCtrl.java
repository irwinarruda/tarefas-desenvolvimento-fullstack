package br.ufg.inf.fullstack.ctrl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ufg.inf.fullstack.ctrl.business.PessoaBusiness;
import br.ufg.inf.fullstack.model.entities.Pessoa;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaCtrl {
	
	@Autowired
	private PessoaBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = business.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Integer id){
		Pessoa retorno = business.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa pessoa){
		pessoa = business.insert(pessoa);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		business.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		pessoa = business.insert(pessoa);
		return ResponseEntity.ok().body(pessoa);
	}
	
}
