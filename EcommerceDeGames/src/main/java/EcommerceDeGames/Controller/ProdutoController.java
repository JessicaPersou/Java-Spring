package EcommerceDeGames.Controller;

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

import EcommerceDeGames.Model.ProdutoModel;
import EcommerceDeGames.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produtogames")
@CrossOrigin(origins = "*", allowedHeaders ="*") 
public class ProdutoController {

	@Autowired 
	private ProdutoRepository proRepository;

	@GetMapping 
	public ResponseEntity<List<ProdutoModel>> getAll() {
		return ResponseEntity.ok(proRepository.findAll());
	}

	@GetMapping("/{id}") 
	public ResponseEntity<ProdutoModel> getById(@PathVariable long id) { 
		return proRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping //
	public ResponseEntity<ProdutoModel> post(@Valid @RequestBody ProdutoModel ProdutoModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(proRepository.save(ProdutoModel));
	}

	@PutMapping
	public ResponseEntity<ProdutoModel> put(@Valid @RequestBody ProdutoModel ProdutoModel) { 

		return proRepository.findById(ProdutoModel.getId())
				.map(resposta -> ResponseEntity.ok().body(proRepository.save(ProdutoModel))) 
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		return proRepository.findById(id).map(resposta -> {
			proRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());

	}

}