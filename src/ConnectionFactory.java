import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.PooledConnection;

import org.postgresql.ds.PGConnectionPoolDataSource;

public class ConnectionFactory {

	private PooledConnection dataSource;
	
	public ConnectionFactory() throws SQLException {
		PGConnectionPoolDataSource dataSource = new PGConnectionPoolDataSource();
		
		dataSource.setURL("jdbc:postgresql://localhost/java_jdbc");
		dataSource.setUser("postgres");
		dataSource.setPassword("123");
		
		this.dataSource = dataSource.getPooledConnection();
	}
	
	public Connection createConnection() throws SQLException {
		return this.dataSource.getConnection();
	}
}
