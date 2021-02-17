import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection connection = connectionFactory.createConnection();
		
		Statement statement = connection.createStatement();
		
		boolean execute = statement.execute("select * from produto");
		
		System.out.println(execute);
		
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");
			
			System.out.println("Id: " + id + ", Nome: " + nome + ", Descrição: " + descricao); 
		}
		
		connection.close();
	}
}
