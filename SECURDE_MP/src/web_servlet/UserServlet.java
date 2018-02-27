package web_servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.mail.smtp.SMTPTransport;

import web_service.AdminService;
import web_service.PasswordAuthentication;
import web_service.UserService;
import beans_model.Product;
import beans_model.User;
import beans_model.Cart;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns = {"/login",
						   "/register",
						   "/logout",
						   "/add",
						   "/sendVerification",
						   "/getProducts",
						   "/getProductId",
						   "/viewProduct",
						   "/addtoCart",
						   "/viewCart"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String duplicateError;
	private String matchError;
	private int productId, userId;
	
	private static final String SECURDE_EMAIL = "securdeproject@gmail.com";
	private static final String SECURDE_PASS = "Securdeproj";
	private static DecimalFormat df2 = new DecimalFormat(".##");

    /**
     * Default constructor. 
     */
    public UserServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(request.getServletPath()) {
			case "/logout": performLogout(request, response); break;
			case "/sendVerification": performVerification(request, response); break;
			case "/getProducts": getProducts(request, response); break;
			case "/viewProduct": viewProduct(request, response); break;
			case "/viewCart": viewCart(request, response); break;
			default: System.out.println("ERROR(Inside userServlet *doGet*): url pattern doesn't match existing patterns.");
		}

		/*request.getQueryString();
		String hash = request.getParameter("verify");
			
		System.out.println("****************VERIFICATION SERVLET*******************");
		UserService.verifyStudent(hash);
		System.out.println("******************************************************");
			
		response.sendRedirect("sign.jsp");*/
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(request.getServletPath()) {
			case "/login": performLogin(request, response); break;
			case "/register": performSignup(request, response); break;
			case "/add": addUsers(request, response); break;
			case "/getProductId": getProductId(request, response); break;
			case "/addtoCart": addtoCart(request, response); break;
			default: System.out.println("ERROR(Inside userServlet *doPost*): url pattern doesn't match existing patterns.");
		}
		
		//doGet(request, response);
	}
	
	/**
	 * Performs logout.
	 * Kills the cookie and the session.
	 * @param request - request object from client
	 * @param response - response object returned to client
	 * @throws ServletException
	 * @throws IOException
	 */
	private void performLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		Cookie[] cookies;
		HttpSession session = request.getSession();
		
		//Kill session
		session.invalidate();
		
		//remove cookies
		cookies = request.getCookies();
		for (Cookie c : cookies) {
			if(c.getName().equals("USER")) {
				c.setMaxAge(0);
				response.addCookie(c);
			} else if(c.getName().equals("ADMIN")) {
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		
		//redirect to homepage.
		System.out.println("Cookie successfully removed!");
		response.sendRedirect("index.jsp");
	}
	
	/**
	 * performs login.
	 * Sends the user to inside the webpage if existing.
	 * If not existing, sends an error message which triggers a popup on webpage.
	 * @param request - request object from client
	 * @param response - response object returned to client
	 * @throws ServletException
	 * @throws IOException
	 */
	private void performLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("logUser");
		String password = request.getParameter("logPass");
		HttpSession s = request.getSession();
		
		System.out.println(email);
		
		//Validate.
		if(UserService.validateUser(email, password)) { 
					
			//check if validated
			if(UserService.isValidated(email)) {
				String userID = UserService.getUserID(email);
				userId = Integer.parseInt(userID);
				//set session attribute
				s.setAttribute("UN", userID); 
				System.out.println("Session(UN): " + s.getAttribute("UN"));
						
							
				//This generates the cookie.
				Cookie theCookie;
				theCookie = new Cookie("USER", userID); 
				theCookie.setMaxAge(604800); //1 week expirey.
					
				//Checking
				System.out.println("Cookie placed: " + theCookie.getName());
				System.out.println("Cookie value: " + theCookie.getValue());
			
				//Add cookie
				response.addCookie(theCookie);
			
				//Redirect inside website
				//response.sendRedirect("UserHomePage.jsp");
				//response.sendRedirect("viewByStudent"); //redirect to view profile.jsp
				response.getWriter().write("PASS-LOGIN-USER");
			} else {
				System.out.println("User not verified!");
				response.getWriter().write("NOT-VERIFIED");
			}
					
		} else if(AdminService.validateAdmin(email, password)) { 
			String userID = AdminService.getAdminID(email);
			//set session attribute
			s.setAttribute("UN", userID); 
			System.out.println("Session(UN): " + s.getAttribute("UN"));
					
						
			//This generates the cookie.
			Cookie theCookie;
			theCookie = new Cookie("ADMIN", userID); 
			theCookie.setMaxAge(604800); //1 week expirey.
						
			//Checking
			System.out.println("Cookie placed: " + theCookie.getName());
			System.out.println("Cookie value: " + theCookie.getValue());

			//Add cookie
			response.addCookie(theCookie);

			//Redirect inside website
			//response.sendRedirect("AdminHomePage.jsp");
			response.getWriter().write("PASS-LOGIN-ADMIN");
					
		} else {
			System.out.println(UserService.isEmailTaken(email) + " | " + AdminService.isExisting(email));
			if(UserService.isEmailTaken(email) || AdminService.isExisting(email)) {
				System.out.println("Wrong username and/or password");
				response.getWriter().write("FAIL-LOGIN");
			} else {
				/*Send error*/
				System.out.println("inValid (User not found)");
				//send error code.
				// TODO front end notif
				response.getWriter().write("NOT-EXIST");
			}
		}
	}
	
	/**
	 * performs sign up.
	 * Adds the user to the database
	 * @param request - request object from client
	 * @param response - response object returned to client
	 * @throws ServletException
	 * @throws IOException
	 */
	private void performSignup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Forwards the work to dataServlet url pattern "add"
		request.getRequestDispatcher("add").forward(request, response);
	}
	
	/**
	 * Add users
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addUsers(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("*****************ADD USER ************************");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("regEmail"); //Email
		String password = request.getParameter("regPass");
		String rePassword = request.getParameter("regRePass");
		
	    String verificationId = UUID.randomUUID().toString().replace("-", "");
	    
	    System.out.println("uuid = " + verificationId);
	    

		//if username OR idnumber OR both has a duplicate in DP, send error message.
		if(checkDuplicates(username)) {
			response.getWriter().write(duplicateError);
		}
		
		else if (checkPassword(password, rePassword)) {
			response.getWriter().write(matchError);
		}
		
		else {
			//Perform hashing here//
			PasswordAuthentication p = new PasswordAuthentication();
	        
			String newPass 			 = p.hash(password.toCharArray()),
				   newVerificationId = p.hash(verificationId.toCharArray());
			
			
			
			User user = new User(firstname, lastname, username, newPass);
			
			UserService.addUser(user, newVerificationId);
			System.out.println("User added but needs verification!");
			
			//Perform sending verification link.
			request.setAttribute("email", username);
			request.setAttribute("verificationId", newVerificationId);
			request.getRequestDispatcher("sendVerification").forward(request, response);

		}
		System.out.println("*******************************************");
	}
	
	private boolean checkDuplicates(String username) {
		// TODO Auto-generated method stub
		boolean hasDuplicate = false;
		ArrayList<String> container = new ArrayList<String>(); //Contains the fields that has duplicates with the DB.
		duplicateError = "";
		
		//Email is already taken.
		if(UserService.isEmailTaken(username)) {
			hasDuplicate = true;
			container.add("EMAIL-TAKEN");
		}
		
		
		if(hasDuplicate) {
			if(container.size() == 1)
				duplicateError = container.get(0);
			else {
				for (int i = 0; i < container.size(); i++) {
					if(i != container.size()-1) {
						duplicateError += container.get(i) + "|";
					}
					else {
						duplicateError += container.get(i);
					}
					
				}
			}
		}
		
		return hasDuplicate;
	}
	
	private boolean checkPassword(String pass, String repass) {
		boolean matchNotPass = false;
		matchError = "";
		if(!repass.equals(pass)) {
			matchNotPass = true;
			matchError = "PASSWORD-MISMATCH";
		}
		
		return matchNotPass;
	}
	
	private void performVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("******************SENDING VERIFICATION********************");
		String email = (String) request.getAttribute("email");
		String newVerificationId = (String) request.getAttribute("verificationId");

		String resultMessage = "";
		int port = request.getServerPort(); //get port of the server.
		String name = request.getServerName(); //get name of server.
		String generatedURL = "http://" + name + ":" + port +"/SECURDE/verification?verify=" + newVerificationId;
		String generatedMsg = 	"Hi!"
								+ "\n\n"
								+ "Please click the link below to activate/confirm your account."
								+ "\n\n"
								+ generatedURL
								+ "\n\n"
								+"Thank you!";
		String subject = "Account Confirmation";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		
		properties.put("mail.smtp.auth", "true"); 
		properties.put("mail.smtp.starttls.enable", "true");

		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.port", "465");

		
		Session session = Session.getInstance(properties,  
			    new javax.mail.Authenticator() {  
					@Override
		      		protected javax.mail.PasswordAuthentication getPasswordAuthentication() {  
		      			return new javax.mail.PasswordAuthentication(SECURDE_EMAIL, SECURDE_PASS);  
		      		}  
		    });
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SECURDE_EMAIL));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(subject);
			message.setContent(generatedMsg, "text/plain");
			
            Transport.send(message/*, username, password*/);
			resultMessage = "Message sent successfully!";
		} catch (MessagingException e) {
			resultMessage = "Unable to send message!";
			e.printStackTrace();
		} finally {
			request.setAttribute("Message", resultMessage);
			//response.sendRedirect("Verification.jsp");
		}
		
		System.out.println("sending done!");
		System.out.println("*****************************************************");
		response.getWriter().write("VALID-SIGNUP");
	}
	
	/**
	 * Retrieves a list of products
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @return List of Posts
	 */
	private void getProducts(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** UPDATING POST FEED ************************");
		Cookie[] cookies;
		ArrayList<Product> productList = UserService.getProducts();
		String htmlPostList = "";
		
		cookies = request.getCookies();
		for (Cookie c : cookies) {
			if(c.getName().equals("USER")) {
				for(Product p : productList){
					htmlPostList += "<div class = 'productListContainer' id = '" + p.getProductId() + "'>" +
									"<img src = 'images/" + p.getProductImage() + "' class = 'img' />" +
									"	<div class='productListDesc'>" +
									"   	<p class = 'productListName'>" + p.getProductName() + "</p>" +
									" 		<p class = 'priceList'>$" + df2.format(p.getPrice()) + "</p>" +
									"	</div>" + 
									"</div> ";
				}
				
				System.out.println(productList);
				response.setContentType("text/html"); 
				response.setCharacterEncoding("UTF-8"); 
				response.getWriter().write(htmlPostList);       
				System.out.println("*******************************************");
			}
			else if(c.getName().equals("ADMIN")) {
				for(Product p : productList){
					htmlPostList += "<div class = 'productListContainer' id = '" + p.getProductId() + "'>" +
									"<img src = 'images/" + p.getProductImage() + "' class = 'img' />" +
									"	<div class='productListDesc'>" +
									"   	<p class = 'productListName'>" + p.getProductName() + "</p>" +
									" 		<p class = 'priceList'>$" + df2.format(p.getPrice()) + "</p>" +
									"	</div>" + 
									"</div> ";
				}
				
				System.out.println(productList);
				response.setContentType("text/html"); 
				response.setCharacterEncoding("UTF-8"); 
				response.getWriter().write(htmlPostList);       
				System.out.println("*******************************************");
			}
			
		}
		
	}
	/**
	* Retrieves the id of the product
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @retur Product id
	 */
	private void getProductId(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** GET PRODUCT ID ************************");
		
		productId = 0;
		try {
			productId = Integer.parseInt(request.getParameter("productId"));
		} catch(NumberFormatException e) {
			System.out.println("Error: UserServlet.java String to Integer parsing updatePost method");
		}

		System.out.println("*******************************************");

	}
	
	/**
	 * Retrieves a product
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @return List of Posts
	 */
	private void viewProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** GETTING PRODUCT ************************");
		
		System.out.println(productId);
		
		Product p = UserService.getProduct(productId);
		String htmlProduct = "";
		

		htmlProduct += "<div class = 'productContainer' id = '" + p.getProductId() + "'>" +
							"<img src = 'images/" + p.getProductImage() + "'></img>" +
							"	<div class = 'productDescCont'>" +
							"		<div class = 'productNameCont'>" +
					        "   		<p class = 'productName'>" + p.getProductName() + "</p>" +
							" 			<span class = 'price'>$" + df2.format(p.getPrice()) + "</span>" +
					        "		</div>" + 
							"		<div class = 'productDesc'>" +
							"			<p class = 'description'>" + p.getProductDescription() + "</p>" +
							"		</div>" +
							"	</div>" + 
					        "</div> ";
		
		System.out.println(p);
	    response.setContentType("text/html"); 
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(htmlProduct);       
		System.out.println("*******************************************");
		
	}

	/**
	 * Add users
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addtoCart(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** ADD TO CART ************************");

		UserService.addtoCart(productId, userId);
		System.out.println("Product added to cart!");

		System.out.println("*******************************************");
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	/**
	 * Retrieves a cart
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @return List of products in cart
	 */
	private void viewCart(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** GETTING PRODUCT ************************");
		HttpSession s = request.getSession();
		String userId = (String) s.getAttribute("UN");
		
		int id = Integer.parseInt(userId);
		ArrayList<Cart> cartList = UserService.getCart(id);

		String htmlProduct = "";
		
		for(Cart c : cartList){
			htmlProduct += "<tr id = '" + c.getProductId() + "'>" +
							"	<td style='display: flex; flex-wrap: nowrap; align-items: center;'>" + 
							"	<img src = 'images/" + c.getImage() + "'></img>" + c.getProductName() + "</td>" +
							"	<td align = 'center' id = 'itemPrice'>" + c.getProductPrice() + "</td>" +
							"	<td align = 'center'><input type = 'text' class = 'quantity' name = 'quantity' /></td>" +
							"	<td align = 'center' id = 'removeRow'><button class = 'removeItem'>X</button></td>" +
							"	<td class = 'priceTag' align = 'center'>" + c.getProductPrice() + "</td>" + 
							"</tr> " +
							"<p id = 'subtotal'>Subtotal:" + c.getSubPrice() + "</p> <br>";
		}
				
		System.out.println(cartList);
		response.setContentType("text/html"); 
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(htmlProduct);       
		System.out.println("*******************************************");

	}
}
