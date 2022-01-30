package com.blogJess.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogJess.Model.PostagemModel;

@Repository// significa que esta interface é um repositorio, responsavel pela comunicação entre o banco de dados atravces de metodos personalizados
public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {// o primeiro parametro indica a Entidade a ser mapeada(o que gerou a tabela tb_postagem), a segunda representa a chave primaria 

	public List<PostagemModel> findAllByTituloContainingIgnoreCase(String titulo);
	
}


