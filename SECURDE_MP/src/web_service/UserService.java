package web_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans_model.Product;
import beans_model.User;
import beans_model.Cart;

public class UserService {
	
	/**
	 * Validates if the student is existing or not.
	 * @param username - entered username(email)
	 * @param password - entered password
	 * @return true or false
	 */
	public static boolean validateUser(String username, String password) {
		boolean found = false;
		PasswordAuthentication p = new PasswordAuthentication(username, password);
		
		System.out.println();
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE email = ? ");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				if(p.authenticate(password.toCharArray(), rs.getString("password"))) {
					System.out.println("User found, valid!");
					found = true;
					break;
				}
			}

			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		return found;
	}
	
	/**
	 * Checks if the username i validated or not.
	 * @param username - the username
	 * @return
	 */
	public static boolean isValidated(String username) {
		boolean validated = true;
		
		System.out.println();
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();

			PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE email = ? " +
					                                      "AND (verificationid IS NULL OR verificationid = \'\')");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();


			//No result was returned. ( Not verified!)
			if(!rs.isBeforeFirst()) {
				System.out.println("Not yet Verified!");
				validated =  false;
			}


			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		return validated;
	}
	
	/**
	 * Retrieves the user ID (on DB)
	 * @param username
	 * @param password
	 * @return String userID OR 0 (not existing)
	 */
	public static String getUserID(String email) {
		System.out.println();
		int id = 0;
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();

			PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.println("Id found!");
				id = rs.getInt("userid");
				break;
			} 
				
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		System.out.println();
		return Integer.toString(id);
		
	}
	
	/**
	 * Checks if the username (email) has already been taken.
	 * @param username - the email
	 * @return true (if taken) or false (not taken)
	 */
	public static boolean isEmailTaken(String username) {
		boolean isTaken = false;
		System.out.println();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			//Checks if result set has any data returned.
			if (!rs.isBeforeFirst()) {    
			    System.out.println("Email not yet taken / not existing"); 
			} 
			else {
				System.out.println("Email is taken.");
				isTaken = true;
			}
			conn.close();
			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		return isTaken;
	}
	
	/**
	 * Adds the user to the database.
	 * @param user - the User object being added.
	 */
	public static void addUser(User user, String verificationId) {
		System.out.println();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();
			
			PreparedStatement stmt =  conn.prepareStatement(
					"INSERT INTO users (fName, lName, " +
					"email, password, verificationId) " +
					"VALUES (?, ?, ?, ?, ?)"
					);
			
			stmt.setString(1, user.getFirstname());
			stmt.setString(2, user.getLastname());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, verificationId);
			
			stmt.executeUpdate();
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	public static void verifyStudent(String hash) {
		System.out.println();
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();
			
			PreparedStatement stmt =  conn.prepareStatement(
					"UPDATE users "
				  + "SET verificationid=? "//1
				 + "WHERE verificationid=?" //2					
					);
			
			stmt.setString(1, "");
			stmt.setString(2, hash);
			
			stmt.executeUpdate();
			
			System.out.println("User verified!");
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		System.out.println();
	}
	
	/**
	 * Retrieves a list of products
	 * @return List of products
	 */
	public static ArrayList<Product> getProducts() {
		System.out.println();
		ArrayList<Product> products = new ArrayList<>();
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();

			PreparedStatement st = conn.prepareStatement("SELECT * FROM pokemerch.products WHERE quantity > 0 order by productid asc;");
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				products.add(new Product(rs.getInt("productid"), rs.getInt("quantity"), rs.getString("productname"), rs.getString("description"), rs.getString("image"), rs.getDouble("price")));
				System.out.println("Product: " + rs.getString("productname"));
			} 
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		System.out.println();
		return products;
		
	}
	
	/**
	 * Retrieves a product
	 * @return prouct
	 */
	public static Product getProduct(int id) {
		System.out.println();
		Product product = null;
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pokemerch.products WHERE productid = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				product = new Product(rs.getInt("productid"), rs.getInt("quantity"), rs.getString("productname"), rs.getString("description"), rs.getString("image"), rs.getDouble("price"));
			} 
			
			System.out.println("Product: " + product.getProductName());
			
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		System.out.println();
		return product;
		
	}

	/**
	 * Adds the product to the cart table.
	 * @param cart - the Cart object being added.
	 */
	public static void addtoCart(int productId, int userId) {
		System.out.println();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();
			
			PreparedStatement stmt =  conn.prepareStatement(
					"INSERT INTO transactions (productid, userid, quantity) " +
					"VALUES (?, ?, ?)"
					);
			
			stmt.setInt(1, productId);
			stmt.setInt(2, userId);
			stmt.setInt(3, 1);
			
			stmt.executeUpdate();
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	/**
	 * Retrieves a list of products in cart
	 * @return List of products in cart
	 */
	public static ArrayList<Cart> getCart(int userId) {
		System.out.println();
		ArrayList<Cart> cart = new ArrayList<>();
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();

			PreparedStatement st = conn.prepareStatement("SELECT t.transactionid, t.productid, t.userid, p.image, p.productname, p.price, t.quantity, SUM(p.price) FROM pokemerch.transactions t, pokemerch.products p WHERE p.productid = t.productid AND t.userid = ? group by t.productid order by transactionid asc;");
			st.setInt(1, userId);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				cart.add(new Cart(rs.getInt("t.transactionid"), rs.getInt("t.productid"), rs.getInt("t.userid"), rs.getString("p.image"), rs.getString("p.productname"), rs.getDouble("p.price"), rs.getInt("t.quantity"), rs.getDouble("SUM(p.price)")));
				//System.out.println("Product: " + rs.getString("p.productname"));
			} 
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		System.out.println();
		return cart;
		
	}

	/**
	 * Adds a product to the database.
	 * @param product - the Product object being added.
	 */
	public static void addProduct(Product product) {
		System.out.println();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();
			
			PreparedStatement stmt =  conn.prepareStatement(
					"INSERT INTO products (productname, description, " +
					"image, quantity, price) " +
					"VALUES (?, ?, ?, ?, ?)"
					);
			
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getProductDescription());
			stmt.setString(3, product.getProductImage());
			stmt.setInt(4, product.getQuantity());
			stmt.setDouble(5, product.getPrice());
			
			stmt.executeUpdate();
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	/**
	 * Removes item in transaction
	 * @param transId - the id of the item
	 */
	public static void deleteItem(int transId) {
		System.out.println();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();
			
			PreparedStatement stmt =  conn.prepareStatement("DELETE FROM pokemerch.transactions WHERE transactionid = ?");
			
			stmt.setInt(1, transId);
			
			stmt.executeUpdate();
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
}
