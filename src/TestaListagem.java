import java.sql.Connection;
import java.sql.SQLException;

import br.com.leo.jdbc.dao.ProdutoDao;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.createConnection()){

			ProdutoDao produtoDao = new ProdutoDao(connection);
			System.out.println(produtoDao.findAll());
		}
	}
}
