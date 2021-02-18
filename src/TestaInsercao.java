import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		String nome = "Novo Produto";
		String descricao = "Novo Produto no banco de dados";
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		
		PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO produto (nome, descricao) VALUES (?, ?)", 
				Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, nome);
		statement.setString(2, descricao);
		
		statement.execute();
		
		ResultSet keys = statement.getGeneratedKeys();
		
		while(keys.next()) {
			int id = keys.getInt("id");
			System.out.println("Novo produto adicionado com id: " + id);
		}
		
		statement.close();
		
		connection.close();
	}
}
