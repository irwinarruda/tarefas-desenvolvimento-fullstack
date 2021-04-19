package br.ufg.inf.fullstack.ctrl;

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

import br.ufg.inf.fullstack.ctrl.business.DisciplinaBusiness;
import br.ufg.inf.fullstack.model.entities.Disciplina;

@RestController
@RequestMapping(value="/disciplinas")
public class DisciplinaCtrl {
	
	@Autowired
	private DisciplinaBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Disciplina>> findAll() {
		List<Disciplina> list = business.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Disciplina> findById(@PathVariable Integer id){
		Disciplina retorno = business.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping
	public ResponseEntity<Disciplina> insert(@RequestBody Disciplina disciplina){
		disciplina = business.insert(disciplina);
		return ResponseEntity.ok().body(disciplina);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		business.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Disciplina> update(@RequestBody Disciplina disciplina){
		disciplina = business.insert(disciplina);
		return ResponseEntity.ok().body(disciplina);
	}
	
}
