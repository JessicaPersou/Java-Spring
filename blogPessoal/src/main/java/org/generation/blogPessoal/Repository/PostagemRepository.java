package org.generation.blogPessoal.Repository;

import java.util.List;

import org.generation.blogPessoal.Model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	/**select + from tb_postagem where titulo like"%primeira%"
	 * 
	 * @param titulo
	 * @return
	 */
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
}
