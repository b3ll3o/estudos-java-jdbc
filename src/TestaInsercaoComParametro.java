import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		String nome = "Novo Produto";
		String descricao = "Descrição Novo Produto";
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(
				"INSERT INTO produto (nome, descricao) VALUES (?, ?)", 
				Statement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, descricao);
		
		preparedStatement.execute();
		
		ResultSet keys = preparedStatement.getGeneratedKeys();
		
		while(keys.next()) {
			int id = keys.getInt("id");
			System.out.println("Novo produto adicionado com id: " + id);
		}
		
		connection.close();
	}
}
