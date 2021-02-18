import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.createConnection()){

			try(PreparedStatement statement = connection.prepareStatement("select * from produto")){
				statement.execute();
								
				try(ResultSet resultSet = statement.getResultSet()){
					
					while(resultSet.next()) {
						Integer id = resultSet.getInt("id");
						String nome = resultSet.getString("nome");
						String descricao = resultSet.getString("descricao");
						
						System.out.println("Id: " + id + ", Nome: " + nome + ", Descrição: " + descricao); 
					}
				}				
			}	
		}
	}
}
