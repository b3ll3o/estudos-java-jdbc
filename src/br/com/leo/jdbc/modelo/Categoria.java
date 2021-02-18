package br.com.leo.jdbc.modelo;

import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos;

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Categoria(Integer id, String nome, List<Produto> produtos) {
		this.id = id;
		this.nome = nome;
		this.produtos = produtos;
	}



	@Override
	public String toString() {
		return "{Id: " + id + ", Nome: " + nome + ", Produtos: " + produtos + "}";
	}

	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

}
