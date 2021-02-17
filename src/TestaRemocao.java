import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		
		Statement statement = connection.createStatement();
		
		statement.execute("DELETE FROM produto WHERE id > 2");
		
		int count = statement.getUpdateCount();
		
		System.out.println(count);
		
		connection.close();
	}
}
