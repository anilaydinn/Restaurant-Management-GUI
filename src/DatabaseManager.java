import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.io.IOException;
import java.sql.Array;
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
	
	public void addProductToCheck(Product product,String table_name) {
		
		String query = "INSERT INTO Checks (table_name,name,quantity,price) VALUES (?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, table_name);
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getQuantity());
			preparedStatement.setDouble(4, product.getPrice());
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Food> getChecks(String tableName) {
		
		ArrayList<Food> output = new ArrayList<Food>();
		String query = "SELECT * FROM Checks WHERE table_name=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, tableName);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				String name = rs.getString("name");
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				
				output.add(new Food(name, price, quantity));
			}
			return output;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public double getTotalPrice(String tableName) {
		
		String query = "SELECt * FROM Checks WHERE table_name=?";
		double totalPrice = 0.0;
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, tableName);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				totalPrice += rs.getDouble("price");
			}
			return totalPrice;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return totalPrice;
		}
	}
	
	public void deleteCheck(String tableName) {
		
		String query = "DELETE FROM Checks WHERE table_name=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, tableName);
			
			preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isFull(String tableName) {
		
		String query = "SELECT * FROM Checks WHERE table_name=?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, tableName);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
