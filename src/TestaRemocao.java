import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().createConnection()){
			
			try(PreparedStatement statement = connection.prepareStatement("DELETE FROM produto WHERE id > ?")){
				
				statement.setInt(1, 2);
				
				statement.execute();
			}
		}
	}
}
