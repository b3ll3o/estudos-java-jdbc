import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		
		Statement statement = connection.createStatement();
		
		statement.execute(
				"INSERT INTO produto (nome, descricao) VALUES ('Novo Produto', 'Novo Produto no banco de dados')",
				Statement.RETURN_GENERATED_KEYS);
		
		ResultSet keys = statement.getGeneratedKeys();
		
		while(keys.next()) {
			int id = keys.getInt("id");
			System.out.println("Novo produto adicionado com id: " + id);
		}
		
		connection.close();
	}
}
