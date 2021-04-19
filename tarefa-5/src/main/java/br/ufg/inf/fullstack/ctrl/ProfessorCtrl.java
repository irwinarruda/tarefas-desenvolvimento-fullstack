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

import br.ufg.inf.fullstack.ctrl.business.ProfessorBusiness;
import br.ufg.inf.fullstack.model.entities.Professor;

@RestController
@RequestMapping(value="/professores")
public class ProfessorCtrl {
	
	@Autowired
	private ProfessorBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Professor>> findAll() {
		List<Professor> list = business.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Professor> findById(@PathVariable Integer id){
		Professor retorno = business.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping
	public ResponseEntity<Professor> insert(@RequestBody Professor professor){
		professor = business.insert(professor);
		return ResponseEntity.ok().body(professor);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		business.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Professor> update(@RequestBody Professor professor){
		professor = business.insert(professor);
		return ResponseEntity.ok().body(professor);
	}
	
}
