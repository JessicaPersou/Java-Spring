package com.blogJess.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogJess.Model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel, Long> {

	public List<TemaModel> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
