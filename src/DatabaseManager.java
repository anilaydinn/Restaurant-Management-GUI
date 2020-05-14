import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;


public class DatabaseManager {

	private Connection con = null;
	private PreparedStatement preparedStatement = null;
	private static DatabaseManager databaseManager = new DatabaseManager();
	
	private DatabaseManager() {
		
		String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_name + "?useUnicode=true&characterEncoding=utf8&useSSL=false";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Driver couldn't find...");
		}
		
		try {
			
			con = DriverManager.getConnection(url,Database.username,Database.password);
			System.out.println("Connection succesful...");
		}
		catch (SQLException e) {
			System.out.println("Connection failed...");
		}
	}
	
	public static DatabaseManager getDatabaseManager() {
		
		return databaseManager;
	}
	
	public void addAccount(String username, String password) {
		
		String query = "INSERT INTO Account (username, password) VALUES (?,?)";
		
		try {
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean login(String username, String password) {
		
		String query = "SELECT * FROM Account WHERE username = ? AND password = ?";
		
		try {
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs.next();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void addItemToCheck(String table_name,Product product) {
		
		String query = "INSERT INTO Checks (table_name, contains, price) VALUES(?, ?, ?)";
		
		try {
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, table_name);
			preparedStatement.setString(2, product.toString());
			preparedStatement.setDouble(3, product.getPrice());
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
