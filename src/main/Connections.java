package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connections
{
	static String dbUrl = "jdbc:mysql://localhost/ECI";
	static String dbClass = "com.mysql.jdbc.Driver";
	static String password = "1905682";
	static String username = "root";
	static Connection connection=null;
	public static Connection OpenConnection()
	{
		if(connection==null)
		{
			try 
			{
	 
				Class.forName(dbClass);
				connection = (Connection) DriverManager.getConnection(dbUrl,
				username, password);	
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return connection;
		}
		else
			return connection;
	}
	public static Connection CloseConnection() throws SQLException
	{
		try
		{
			connection.close();
		}
		catch(SQLException ex)
		{}
		return connection;
	}
}
