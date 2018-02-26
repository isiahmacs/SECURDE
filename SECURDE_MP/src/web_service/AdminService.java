package web_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminService {
	
	/**
	 * Validates if the admin is existing or not.
	 * @param username
	 * @param password
	 * @return true or false
	 */
	public static boolean validateAdmin(String username, String password) {
		boolean found = false;
		PasswordAuthentication p = new PasswordAuthentication();
		
		System.out.println();
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM admins WHERE email = ?");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
		
			while(rs.next()) {
				if(password.equals(rs.getString("password"))) {
					System.out.println("Admin found, valid!");
					found = true;
					break;
				}
			}
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		System.out.println();
		return found;
	}
	
	/**
	 * Retrieves the admin ID.
	 * @param username
	 * @param password
	 * @return String userID
	 */
	public static String getAdminID(String email) {
		System.out.println();
		int id = 0;
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();

			PreparedStatement st = conn.prepareStatement("SELECT * FROM admins WHERE email = ?");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
	
			while(rs.next()) {
				System.out.println("Id found!");
				id = rs.getInt("id");
				break;
			} 
				
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		System.out.println();
		return Integer.toString(id);
	}
	
	/**
	 * Checks if email is existing in the admin table.
	 * @param email
	 * @return
	 */
	public static boolean isExisting(String email) {
		boolean found = true;
		
		System.out.println();
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DatabaseManager.getConnection();

			PreparedStatement st = conn.prepareStatement("SELECT * FROM admins WHERE email = ?");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();


		    //Email does not exist.
			if(!rs.isBeforeFirst()) {
				System.out.println("Email does not exist!(ADMIN)");
				return false;
			}
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		System.out.println();
		return found;
	}
	
}
