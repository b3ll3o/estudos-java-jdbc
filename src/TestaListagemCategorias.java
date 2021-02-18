import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.leo.jdbc.dao.CategoriaDao;
import br.com.leo.jdbc.modelo.Categoria;

public class TestaListagemCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().createConnection()){
			
			CategoriaDao categoriaDao = new CategoriaDao(connection);	
			//ProdutoDao produtoDao = new ProdutoDao(connection);
			
			List<Categoria> categorias = categoriaDao.findAll();
			//List<List<Produto>> produtos = new ArrayList<>();
			
//			categorias.forEach(c -> {
//				try {
//					produtos.add(produtoDao.find(c));
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			});
//			
			System.out.println(categorias);
		}
	}
}
