package EcommerceDeGames.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name ="tb_produto") 
public class ProdutoModel {
	
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private long id;
		
		@NotNull 
		@Size(min = 3, max = 100) 
		private String titulo;
		
		@NotNull 
		private float preco;
		
		@NotNull 
		private int quantidade;
		
		@Temporal(TemporalType.TIMESTAMP) 
		private Date date = new java.sql.Date(System.currentTimeMillis());
		
		
		//relacionamento
		@ManyToOne
		@JsonIgnoreProperties("produtos")
		private CategoriaModel categoria;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
			
		public String getTitulo(){
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
		public float getPreco() {
			return preco;
		}
		public void setPreco(float preco) {
			this.preco = preco;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		
}


