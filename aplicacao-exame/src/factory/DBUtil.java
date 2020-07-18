package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection()
	{
		Connection conn = null;
		try 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/exames?useTimezone=true&serverTimezone=UTC","root","admin");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
