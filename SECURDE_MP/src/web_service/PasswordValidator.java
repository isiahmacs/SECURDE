package web_service;
import java.util.regex.*;

public class PasswordValidator {
	private static Pattern pattern;
	private static Matcher matcher;
	
	private static final String PASSWORD_REGEX = "("
			+ "(?=.*\\d)"
			+ "(?=.*[a-z])"
			+ "(?=.*[A-Z])"
			+ ".{8,50}"
	+ ")";
	
	public PasswordValidator() {
		pattern = Pattern.compile(PASSWORD_REGEX);
	}
	
	public boolean validate (String password) { //parameter is the password itself
		System.out.println(password);
		matcher = pattern.matcher(password);
		System.out.println(matcher.matches());
		return matcher.matches(); //returns true or false
	}
	
	/* In another class...
	 * PasswordValidator pv = new PasswordValidator();
	 * 
	 * System.out.println("S3curd3"); //will return true
	 * System.out.println("SECURDE"); //will return false; no lowercase, no digits
	 **/
}
