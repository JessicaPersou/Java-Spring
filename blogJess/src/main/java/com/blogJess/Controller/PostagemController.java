package com.blogJess.Controller;

import java.util.List;

import javax.validation.Valid;

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

import com.blogJess.Model.PostagemModel;
import com.blogJess.Repository.PostagemRepository;

@RestController // Classe responsavel por receber requisiçoes Web o 
@RequestMapping("/postagem") /*indica o endereço do endpoint que a controlodaroa responderá as requisiçoes*/
@CrossOrigin(origins="*", allowedHeaders="*")// indica que a classe recebera requisiçoes de fora do dominio(localhost), essencial para o front end consumir a API livera origens e cabeçalho de requisiçoes
public class PostagemController {
		
	@Autowired // ingeção de dependencia
	private PostagemRepository pRepository;
	
	@GetMapping
	public ResponseEntity<List<PostagemModel>> getAll(){
		return ResponseEntity.ok(pRepository.findAll()); // ok= 200
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostagemModel> getById(@PathVariable long id){
		return pRepository.findById(id)
				.map(resp ->ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<PostagemModel> postPostagem(@Valid @RequestBody PostagemModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(pRepository.save(postagem));
	
	}
	
	@PutMapping
	public ResponseEntity<PostagemModel> putPostagem(@Valid @RequestBody PostagemModel postagem){
		return pRepository.findById(postagem.getId())
				.map(resp-> ResponseEntity.ok().body(pRepository.save(postagem)))
				.orElse(ResponseEntity.notFound().build());
			
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable long id){
		return pRepository.findById(id)
				.map(resp ->{
					pRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());		
	}
	
}