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

import br.ufg.inf.fullstack.ctrl.business.OfertaBusiness;
import br.ufg.inf.fullstack.model.entities.Oferta;

@RestController
@RequestMapping(value="/ofertas")
public class OfertaCtrl {
	
	@Autowired
	private OfertaBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Oferta>> findAll() {
		List<Oferta> list = business.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Oferta> findById(@PathVariable Integer id){
		Oferta retorno = business.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping
	public ResponseEntity<Oferta> insert(@RequestBody Oferta oferta){
		oferta = business.insert(oferta);
		return ResponseEntity.ok().body(oferta);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		business.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Oferta> update(@RequestBody Oferta oferta){
		oferta = business.insert(oferta);
		return ResponseEntity.ok().body(oferta);
	}
	
}
