package EcommerceDeGames.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // indica que a classe é uma propriedade do JPA hibernate
@Table(name = "tb_categoria") // essa entidade dentro do banco de dados vai virar uma tabela com o nome // passado em parâmetro
public class CategoriaModel {

	// atributos da classe/tabela
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private long id;

	@NotNull // não pode vir titulo vazio
	@Size(min = 3, max = 100) // determina o tamanho do texto
	private String titulo;

	@NotNull
	@Size(min = 3, max = 100)
	private String descricao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel> produtos;
	// chave estrangeira da classe tema no id
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
