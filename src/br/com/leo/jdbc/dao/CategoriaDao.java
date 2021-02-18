package br.com.leo.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.leo.jdbc.modelo.Categoria;
import br.com.leo.jdbc.modelo.Produto;

public class CategoriaDao {

	private Connection connection;
	
	public CategoriaDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> findAll() throws SQLException{
		try(PreparedStatement statement = connection.prepareStatement(
				"SELECT c.id, c.nome, p.id, p.nome, p.descricao FROM categoria c JOIN produto p ON p.categoria_id = c.id ORDER BY p.categoria_id")){
			
			statement.execute();
			
			try(ResultSet result = statement.getResultSet()){
				List<Categoria> categorias = new ArrayList<>();
				while(result.next()) {
					List<Produto> produtos = new ArrayList<>();
					produtos.add(new Produto(result.getInt(3), result.getString(4), result.getString(5)));
					categorias.add(new Categoria(result.getInt(1), result.getString(2), produtos));
				}
				return categorias;
			}
		}
	}
}
