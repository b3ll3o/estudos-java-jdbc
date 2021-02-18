import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection connection = connectionFactory.createConnection();
		
		PreparedStatement statement = connection.prepareStatement("select * from produto");
		
		boolean execute = statement.execute();
		
		System.out.println(execute);
		
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");
			
			System.out.println("Id: " + id + ", Nome: " + nome + ", Descri��o: " + descricao); 
		}
		
		statement.close();
		
		connection.close();
	}
}
