package org.generation.blogPessoal.Controller;

import java.util.List;

import org.generation.blogPessoal.Model.Tema;
import org.generation.blogPessoal.Repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {
	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long id){
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/decricao/{descricao}")
	public ResponseEntity<List<Tema>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}


	@PostMapping
	public ResponseEntity<Tema> postTema (@RequestBody Tema Tema){
		 return ResponseEntity.status(HttpStatus.CREATED)
				 .body(repository.save(Tema));
		
	}
	
	@PutMapping
	public ResponseEntity<Tema> putTema (@RequestBody Tema tema){
		return ResponseEntity.ok(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTema(@PathVariable long id){
		return repository.findById(id)
				.map(resposta ->{
					repository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
