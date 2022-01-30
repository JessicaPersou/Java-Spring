package com.blogJess.Controller;

import java.util.List;

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

import com.blogJess.Model.TemaModel;
import com.blogJess.Repository.TemaRepository;

@RestController // esta classe comunica com o cliente
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {

	@Autowired
	private TemaRepository tRepository;

	@GetMapping
	public ResponseEntity<List<TemaModel>> getAll() {
		return ResponseEntity.ok(tRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> getById(@PathVariable long id) {
		return tRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/decricao/{descricao}")
	public ResponseEntity<List<TemaModel>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(tRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public ResponseEntity<TemaModel> postTemaModel(@RequestBody TemaModel TemaModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tRepository.save(TemaModel));

	}

	@PutMapping
	public ResponseEntity<TemaModel> putTemaModel(@RequestBody TemaModel TemaModel) {
		return ResponseEntity.ok(tRepository.save(TemaModel));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTemaModel(@PathVariable long id) {
		return tRepository.findById(id).map(resp -> {
			tRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
}