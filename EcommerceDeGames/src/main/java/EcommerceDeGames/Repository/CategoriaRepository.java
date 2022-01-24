package EcommerceDeGames.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EcommerceDeGames.Model.CategoriaModel;

@Repository// a interface extende de outra interface JPA que tem a função de sinalizar que a classe é um repositorio e pode manipular alguns dados no banco de dados 
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{		//com a model e tipo de id no ripo primitivo como parametros
	
	public List<CategoriaModel> findAllByTituloContainingIgnoreCase(String titulo);
	//busca todos pelo nome do atributo da minha entidade, e ignorar as letras em maiuculo e minusculo
	
}