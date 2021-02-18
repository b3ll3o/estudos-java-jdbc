import java.sql.Connection;
import java.sql.SQLException;

import br.com.leo.jdbc.dao.ProdutoDao;
import br.com.leo.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Novo Produto", "Novo Produto descrição");
		
		try(Connection connection = new ConnectionFactory().createConnection()){
			ProdutoDao produtoDao = new ProdutoDao(connection);
			produtoDao.save(produto);
			System.out.println(produtoDao.findAll());
		}
	}
}
