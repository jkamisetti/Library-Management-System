import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

class sqlqueryprocessor {
	static Connection ConnectionObj = null;
	static Statement stmt;
	public void startDatabase()
	{
		try {
			// Create a connection to the local MySQL server, with the "company" database selected.
			//		ConnectionObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "mypassword");
			// Create a connection to the local MySQL server, with the NO database selected.
			ConnectionObj = DriverManager.getConnection("jdbc:mysql://localhost/company", "root", "password");
			// Create a SQL statement object and execute the query.
			Statement stmt = ConnectionObj.createStatement();
		
			// Set the current database, if not already set in the getConnection
			// Execute a SQL statement
			stmt.execute("use company;");
		} 
		catch(SQLException ex) {
			System.out.println("Error in connection: " + ex.getMessage());
		}
		
	}
		public ResultSet RunQuery(String sqlQuery) {

			ResultSet rs = null;
			try{
			// Execute a SQL query using SQL as a String object
			rs = stmt.executeQuery(sqlQuery);
			// Always close the recordset and connection.
			}catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
			return rs;

	}

		public void stopDatabase()
		{
			try{
			ConnectionObj.close();
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
}