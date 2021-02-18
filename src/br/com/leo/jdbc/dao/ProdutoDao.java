package br.com.leo.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.leo.jdbc.modelo.Produto;

public class ProdutoDao {

	private Connection connection;
	
	public ProdutoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Produto produto) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO produto (nome, descricao) VALUES (?, ?)", 
				Statement.RETURN_GENERATED_KEYS)){
			
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());
			
			statement.execute();
			
			try(ResultSet result = statement.getGeneratedKeys()){
				while(result.next()) {
					produto.setId(result.getInt(1));
				}
			}
		}
	}
	
	public List<Produto> findAll() throws SQLException{
		try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM produto")){
			statement.execute();
							
			try(ResultSet resultSet = statement.getResultSet()){
				
				List<Produto> produtos = new ArrayList<>();
				while(resultSet.next()) {
					Integer id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");
					String descricao = resultSet.getString("descricao");
					
					Produto produto = new Produto(id, nome, descricao);
					
					produtos.add(produto);
				}
				return produtos;
			}				
		}	
	}
}
