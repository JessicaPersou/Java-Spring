package com.blogJess.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogJess.Model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long> {
	
	
	public List<TemaModel> findAllByDescricaoContainingIgnoreCase(String descricao);
	public Optional<TemaModel> findAllByDescricao(String string);
	
}
