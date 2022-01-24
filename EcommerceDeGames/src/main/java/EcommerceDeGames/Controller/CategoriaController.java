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

import EcommerceDeGames.Model.CategoriaModel;
import EcommerceDeGames.Repository.CategoriaRepository;



@RestController // Classe controlador repsonsavel por receber requisições da web
@RequestMapping("/categoriagames") // caminho para receber as requisições
@CrossOrigin(origins = "*", allowedHeaders ="*") // conexão com o front-end, aceita requisiçoes de qualquer origem
public class CategoriaController {

	@Autowired // permite que os servicos seja acessados a partir do controller
	private CategoriaRepository catRepository;

	@GetMapping // sempre que vir uma requisição ele vai disparar esse metodo
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(catRepository.findAll());
	}

	@GetMapping("/{id}") // precisa passar o parametro de quem vai fazer a requisição
	public ResponseEntity<CategoriaModel> getById(@PathVariable long id){ //essa variavel é do caminho da URI
		return catRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping // envia conteúdo 
	public ResponseEntity<CategoriaModel> post(@Valid @RequestBody CategoriaModel CategoriaModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(catRepository.save(CategoriaModel));
	}

	@PutMapping // atualiza conteúdo
	public ResponseEntity<CategoriaModel> put(@Valid @RequestBody CategoriaModel CategoriaModel) { // 

		return catRepository.findById(CategoriaModel.getId())
				.map(resposta -> ResponseEntity.ok().body(catRepository.save(CategoriaModel))) // salva e mostra na body 
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}") // deleta conteúdothub
	
	public ResponseEntity<?> delete(@PathVariable long id) {
		return catRepository.findById(id).map(resposta -> {
			catRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());

	}

}