import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.createConnection()){
			
			connection.setAutoCommit(false);
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO produto (nome, descricao, categoria_id) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
				
				adicionarVariavel("Televisão", "Televisão samsung", 1, preparedStatement);
				adicionarVariavel("microondas", "microondas samsung", 1, preparedStatement);
				
				connection.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, Integer categoriaId, PreparedStatement preparedStatement)
			throws SQLException {
		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, descricao);
		preparedStatement.setInt(3, categoriaId);

		preparedStatement.execute();

		try(ResultSet keys = preparedStatement.getGeneratedKeys()){
			
			while (keys.next()) {
				int id = keys.getInt("id");
				System.out.println("Novo produto adicionado com id: " + id);
			}
		}

	}
}
