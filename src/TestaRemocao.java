import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		
		PreparedStatement statement = connection.prepareStatement("DELETE FROM produto WHERE id > ?");
		
		statement.setInt(1, 2);
		
		statement.execute();
		
		int count = statement.getUpdateCount();
		
		System.out.println(count);
		
		connection.close();
	}
}
