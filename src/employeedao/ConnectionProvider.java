package employeedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user="jinwoo";
	private static final String password="1234";
	
	public static Connection geConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url,user,password);
	}
}
