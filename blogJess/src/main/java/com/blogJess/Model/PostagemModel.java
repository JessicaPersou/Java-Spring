package com.blogJess.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class PostagemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message=" O atributo título é obrigatorio e não pode ter espaços em branco.")
	@Size(min=3,max=100, message=" O atributo t´tulo deve conter no mínimo 3 e nomáximo 100 caracteres.")
	private String titulo;
	
	@NotNull(message=" O atributo texto é obrigatorio e não pode ter espaços em branco.")
	@Size(min=3,max=500, message=" O atributo texto deve conter no mínimo 3 e nomáximo 500 caracteres.")
	private String texto;
	
	
	@UpdateTimestamp // será atualizado de acordo com a hora e data do sistema
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaModel tema; // chave estrangeira da classe tema no id


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


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}

	
}
