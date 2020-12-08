package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {

	private static Connection connection;

	static {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/dbSGE", "SA", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
