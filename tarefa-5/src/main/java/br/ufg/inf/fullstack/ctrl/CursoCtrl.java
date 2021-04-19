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

import br.ufg.inf.fullstack.ctrl.business.CursoBusiness;
import br.ufg.inf.fullstack.model.entities.Curso;

@RestController
@RequestMapping(value="/cursos")
public class CursoCtrl {

	@Autowired
	private CursoBusiness business;

	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		List<Curso> list = business.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Integer id){
		Curso retorno = business.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping
	public ResponseEntity<Curso> insert(@RequestBody Curso curso){
		curso = business.insert(curso);
		return ResponseEntity.ok().body(curso);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		business.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Curso> update(@RequestBody Curso curso){
		curso = business.insert(curso);
		return ResponseEntity.ok().body(curso);
	}
}

