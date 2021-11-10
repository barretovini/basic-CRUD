package com.games.vini.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Jogos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;
	
	@NotEmpty(message = "Selecione a classificação")
	private String classificacao;
	
	@NotEmpty(message = "Gênero não pode ser vazio.")
	private String genero;
	
	@Digits(fraction = 2, integer = 10)
	private BigDecimal preco;
	
	@OneToMany(mappedBy = "jogos")
	private List<Usuario> usuario; 

	@NotEmpty(message = "Selecione a plataforma.")
	private String plataforma;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lancamento;	
	 
	public String getGenero() {
		return genero;
	}

	public Date getLancamento() {
		return lancamento;
	}

	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

}
