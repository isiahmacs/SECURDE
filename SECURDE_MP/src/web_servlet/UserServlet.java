package web_servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sun.mail.smtp.SMTPTransport;

import web_service.AdminService;
import web_service.PasswordAuthentication;
import web_service.UserService;
import beans_model.Product;
import beans_model.User;
import beans_model.Cart;
import beans_model.Order;

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
						   "/viewProductForAdmin",
						   "/addtoCart",
						   "/viewCart",
						   "/removeItem",
						   "/updateItem",
						   "/addProduct",
						   "/viewEditProduct",
						   "/editProduct",
						   "/removeProduct",
						   "/viewOrders",
						   "/cancelOrder",
						   "/checkOut"})
@MultipartConfig
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
			case "/getProductId": getProductId(request, response); break;
			case "/viewProduct": viewProduct(request, response); break;
			case "/viewProductForAdmin": viewProductForAdmin(request, response); break;
			case "/viewEditProduct": viewEditProduct(request, response); break;
			case "/viewCart": viewCart(request, response); break;
			case "/viewOrders": viewOrders(request, response); break;
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
			case "/addtoCart": addtoCart(request, response); break;
			case "/addProduct": addProduct(request, response); break;
			case "/removeItem": removeItem(request, response); break;
			case "/updateItem": updateItem(request, response); break;
			case "/editProduct": editProduct(request, response); break;
			case "/removeProduct": removeProduct(request, response); break;
			case "/cancelOrder": cancelOrder(request, response); break;
			case "/checkOut": checkOut(request, response); break;
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
		System.out.println("***************** UPDATING PRODUCT FEED ************************");
		ArrayList<Product> productList = UserService.getProducts();
		String htmlPostList = "";
		boolean found = false;
		HttpSession s = request.getSession();
		
		Cookie[] cookieList = request.getCookies();
			for (Cookie c : cookieList) {
				if(!found) {
					if(c.getName().equals("USER")) {
						s.setAttribute("UN", c.getValue()); 
						Cookie[] list = request.getCookies();
						for (Cookie cookie : list) {
							if(cookie.getName().equals("GUEST")) {
								found = true;
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					} else if(c.getName().equals("ADMIN")) {
						Cookie[] list = request.getCookies();
						for (Cookie cookie : list) {
							if(cookie.getName().equals("GUEST")) {
								found = true;
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					} else {
						Cookie theCookie;
						theCookie = new Cookie("GUEST", "0"); 
						s.setAttribute("UN", theCookie.getValue()); 
						theCookie.setMaxAge(604800); //1 week expirey.
							
						//Checking
						System.out.println("Cookie placed: " + theCookie.getName());
						System.out.println("Cookie value: " + theCookie.getValue());
					
						//Add cookie
						response.addCookie(theCookie);
					}
				} else break;
			}
		
		for(Product p : productList){
			htmlPostList += "<form action = 'getProductId' method = 'GET' class = 'forms'>" +
							"	<button type = 'submit' class = 'product' name = 'prod' value = '" + String.format("%d", p.getProductId()) + "'>" +
							"	<div class = 'productContainer'>" +
							"   	<img src = 'images/" + p.getProductImage() + "' class = 'img' />" +
							" 		<div class='productDesc'>" +
							"			<p class = 'productName'>" + p.getProductName() + "</p>" + 
							"			<p class = 'price'>" + df2.format(p.getPrice()) + "</p>" + 
							"		</div> " +
							"	</div>" +
							"	</button>" +
							"</form>";
			System.out.println(p.getProductId());
		}
				
		System.out.println(productList);
		response.setContentType("text/html"); 
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(htmlPostList);       
		System.out.println("*******************************************");
			
		
	}
	
	private void getProductId(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** GETTING PRODUCT ID ************************");
		Cookie[] cookies;
		productId = 0;
		String id = request.getParameter("prod");
		System.out.println(id);
		try {
			productId = Integer.parseInt(request.getParameter("prod"));
		} catch(NumberFormatException e) {
			System.out.println("Error: UserServlet.java String to Integer parsing updatePost method");
		}
		System.out.println("*******************************************");
		
		cookies = request.getCookies();
		for (Cookie c : cookies) {
			if(c.getName().equals("USER")) {
					request.getRequestDispatcher("userproduct.jsp").forward(request, response);
			} else if(c.getName().equals("ADMIN")) {
					request.getRequestDispatcher("adminproduct.jsp").forward(request, response);
			} else if (c.getName().equals("GUEST")) {
				request.getRequestDispatcher("indexproduct.jsp").forward(request, response);
			}
		}
	}
	
	/**
	 * Retrieves a product for users/guests
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @return List of Posts
	 */
	private void viewProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** GETTING PRODUCT ************************");
		
		System.out.println(userId);
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
					   "</div>";
				
		System.out.println(p);
		response.setContentType("text/html"); 
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(htmlProduct);       
		System.out.println("*******************************************");
	}
	
	/**
	 * Retrieves a product for admin
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @return List of Posts
	 */
	private void viewProductForAdmin(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** GETTING PRODUCT ************************");
		
		System.out.println(userId);
		Product p = UserService.getProduct(productId);
		String htmlProduct = "";
		
		htmlProduct += "<form action = 'removeProduct' method = 'POST'>" +
     		   		   "<a href = 'editProduct.jsp'><button id = 'editProduct'>Edit Product</button></a>" +
     		   		   "<button id = 'removeProduct' type = 'submit' name = 'removeProd' value = '" + p.getProductId() + "'>Remove Product</button></a>" +
					   "<div class = 'productContainer' id = '" + p.getProductId() + "'>" +
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
					   "</div>" +
					   "</form>";
				
		System.out.println(p);
		response.setContentType("text/html"); 
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(htmlProduct);       
		System.out.println("*******************************************");
	}

	/**
	 * Add product to cart
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addtoCart(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** ADD TO CART ************************");
		Cookie[] cookies;
		
		UserService.addtoCart(productId, userId);
		System.out.println("Product added to cart!");

		System.out.println("*******************************************");
		cookies = request.getCookies();
		for (Cookie c : cookies) {
			if(c.getName().equals("USER")) {
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			} else if(c.getName().equals("GUEST")) {
				request.getRequestDispatcher("indexcart.jsp").forward(request, response);
			}
		}
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
		System.out.println("***************** GETTING CART ************************");
		HttpSession s = request.getSession();
		
		double totalPrice = 0;
		String userId = (String) s.getAttribute("UN");
		System.out.println(userId);
		
		int id = Integer.parseInt(userId);
		ArrayList<Cart> cartList = UserService.getCart(id);

		String htmlProduct = "";
		if(cartList != null) {
			for(Cart c : cartList){
				htmlProduct += "<form action = 'updateItem' method = 'POST'>" +
							   "<form action = 'removeItem' method = 'POST' class = 'formTable'>" +
							   "	<div id = '" + c.getProductId() + "' class = 'rowData'>" +
							   "		<div class = 'td' style = 'display: flex; align-items: center; width: 681.5px;'>" + 
							   "		<img src = 'images/" + c.getImage() + "'></img>" + c.getProductName() + "</div>" +
							   "		<div class = 'td' style = 'width: 60px;'>$" + c.getProductPrice() + "</div>" +
							   "		<div class = 'td' style = 'width: 68.5px;'><input type = 'number' class = 'quantity' name = 'quantity' min = '0' value = '" + c.getQuantity() + "' /></div>" +
							   "		<div class = 'td' style = 'width: 42px;'><button type = 'submit' class = 'removeItem' name = 'remove' value = '" + c.getTransId() + "'>X</button></div>" +
							   "		<div class = 'td' style = 'width: 56px;'>$" + (c.getQuantity() * c.getProductPrice()) + "</div>" + 
							   "		<div class = 'td' style = 'width: 55.5px; border-right: 1px solid #ABB2B9;'><button type = 'submit' class = 'update' name = 'update' value = '" + c.getTransId() + "'>Update Item</button></div>" +
							   "	</div>" +
							   "</form>" +
							   "</form>";
				
				totalPrice += (c.getQuantity() * c.getProductPrice());
			}
			
			request.getSession().setAttribute("total", totalPrice);
			System.out.println(cartList);
			response.setContentType("text/html"); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().write(htmlProduct);
			System.out.println("*******************************************");
		} else {
			response.getWriter().write("NO-ITEMS-CART");
			System.out.println("*******************************************");
		}

	}

	/**
	 * Add products
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** ADD PRODUCT ******************");
		
		String productName = request.getParameter("prodName");
		double productPrice = Double.parseDouble(request.getParameter("prodPrice"));
		int productQuantity = Integer.parseInt(request.getParameter("prodQuantity")); 
		String productDesc = request.getParameter("prodDesc");
		String productImage = request.getParameter("prodImage");
		
		System.out.println(productImage);
		
	    Product product = new Product(productQuantity, productName, productDesc, productImage, productPrice);
			
		UserService.addProduct(product);
		System.out.println("Product added!");

		System.out.println("*******************************************");
		response.sendRedirect("admin.jsp");
	}
	
	/**
	 * Removes item in cart
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void removeItem(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** REMOVE ITEM ******************");
		Cookie[] cookies;
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("remove")); 
		} catch(NumberFormatException e) {
			System.out.println("Error: UserServlet.java String to Integer parsing removeItem method");
		}
		
		UserService.deleteItem(id);
		System.out.println("Item removed!");

		System.out.println("*******************************************");
		cookies = request.getCookies();
		for (Cookie c : cookies) {
			if(c.getName().equals("USER")) {
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			} else if(c.getName().equals("GUEST")) {
				request.getRequestDispatcher("indexcart.jsp").forward(request, response);
			}
		}
	}
	
	/**
	 * Updates item in cart
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateItem(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** REMOVE ITEM ******************");
		Cookie[] cookies;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("update")); 
		} catch(NumberFormatException e) {
			System.out.println("Error: UserServlet.java String to Integer parsing updateItem method");
		}
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		UserService.updateItem(id, quantity);
		System.out.println("Item updated!");

		System.out.println("*******************************************");
		cookies = request.getCookies();
		for (Cookie c : cookies) {
			if(c.getName().equals("USER")) {
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			} else if(c.getName().equals("GUEST")) {
				request.getRequestDispatcher("indexcart.jsp").forward(request, response);
			}
		}
	}

	/**
	 * Views edit form of a product
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @return Product info
	 */
	private void viewEditProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** EDIT PRODUCT ************************");
		
		
		Product p = UserService.getProduct(productId);
		String htmlProduct = "";
		
		htmlProduct += "<div id = 'editProductContainer'>" +
					   "<img src = 'images/" + p.getProductImage() + "' class = 'img' id = 'image'></img>" +
					   "	<div id = 'productDescCont'>" +
					   "		<form action = 'editProduct' method = 'POST' id = 'editProdForm' novalidate>" +
					   " 			<input type = 'text' value = '" + p.getProductName() + "' id = 'prodname' name = 'prodName' class = 'upload' required /> <br>" +
					   "			<input type = 'number' value = '" + p.getPrice() + "' id = 'prodprice' name = 'prodPrice' class = 'upload' min = '0.01' step = '0.01' required /> <br>" +
					   "			<input type = 'number' value = '" + p.getQuantity() + "' id = 'prodquantity' name = 'prodQuantity' class = 'upload' min = '1' required /> <br>" +
					   "			<textarea id = 'proddesc' name = 'prodDesc' class = 'upload' required>" + p.getProductDescription() + "</textarea> <br><br>" +
					   "			<label for = 'prodImage' class='custom-file-upload' id = 'label'>" + p.getProductImage() + "</label>" +
					   "			<input type = 'file' id = 'prodImage' name = 'prodImage' class = 'upload' accept='.png, .jpg, .jpeg' required /> <br><br>" +
					   "			<button type = 'submit' name = 'editProdId' id = 'editProdBtn' value = '" + p.getProductId() + "'>Update Product</button>" +
					   "		</form>" +
					   "	</div>" +
					   "</div>";
		System.out.println(p);
		response.setContentType("text/html"); 
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(htmlProduct);       
		System.out.println("*******************************************");
	}

	/**
	 * Edits product
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** EDIT PRODUCT ******************");
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("editProdId")); 
		} catch(NumberFormatException e) {
			System.out.println("Error: UserServlet.java String to Integer parsing removeProduct method");
		}

		String productName = request.getParameter("prodName");
		double productPrice = Double.parseDouble(request.getParameter("prodPrice"));
		int productQuantity = Integer.parseInt(request.getParameter("prodQuantity")); 
		String productDesc = request.getParameter("prodDesc");
		String productImage = request.getParameter("prodImage");
		
			
		UserService.editProduct(id, productName, productPrice, productQuantity, productDesc, productImage);
		System.out.println("Product edited!");

		System.out.println("*******************************************");
		response.sendRedirect("adminproduct.jsp");
	}

	/**
	 * Removes product
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void removeProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** REMOVE PRODUCT ******************");
		Cookie[] cookies;
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("removeProd")); 
		} catch(NumberFormatException e) {
			System.out.println("Error: UserServlet.java String to Integer parsing removeProduct method");
		}
		
		UserService.deleteProduct(id);
		System.out.println("Product removed!");

		System.out.println("*******************************************");
		response.sendRedirect("admin.jsp");
	}
	
	/**
	 * Retrieves all confirmed orders
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @return List of products in cart
	 */
	private void viewOrders(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** GETTING ORDERS ************************");
		
		ArrayList<Order> orderList = UserService.getOrders();

		String htmlProduct = "";
		if(orderList != null) {
			for(Order o : orderList){
				htmlProduct += "<form action = 'cancelOrder' method = 'POST'>" +
							   "	<div class = 'transContainer'>" +
							   "		<img src = 'images/" + o.getProductImage() + "'></img>" +
							   "		<div class = 'transDescCont'>" +
							   "			<p class = 'productName'>Product: " + o.getProductName() + "</p>" +
							   "			<p class = 'productPrice'>Retail Price: " + o.getRetailPrice() + "</p>" + 
							   "			<p class = 'productQuantity'>Quantity: " + o.getProductQuantity() + "</p>" + 
							   "			<p class = 'productTotalPrice'>Total Price: " + o.getTotalPrice() + "</p>" + 
							   "			<p class = 'productBuyer'>Ordered by: " + o.getProductBuyer() + "</p>" + 
							   "			<p class = 'productBuyerEmail'>Email: " + o.getProductBuyerEmail() + "</p>" +
							   "			<button type = 'submit' name = 'cancel' class = 'cancelOrderBtn' value = '" + o.getTransactionId() + "'>Cancel Order</button>" +
							   "		</div>" +
							   "	</div><br>" +
							   "</form>";
			}
					
			System.out.println(orderList);
			response.setContentType("text/html"); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().write(htmlProduct);       
			System.out.println("*******************************************");
		} else {
			response.getWriter().write("NO-ITEMS-CART");
			System.out.println("*******************************************");
		}

	}
	
	/**
	 * Removes order
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void cancelOrder(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** REMOVE PRODUCT ******************");
		Cookie[] cookies;
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("cancel")); 
		} catch(NumberFormatException e) {
			System.out.println("Error: UserServlet.java String to Integer parsing removeProduct method");
		}
		
		UserService.deleteOrder(id);
		System.out.println("Order removed!");

		System.out.println("*******************************************");
		response.sendRedirect("orders.jsp");
	}
	
	/**
	 * Adds the address and confirms the order
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @return List of products in cart
	 */
	private void checkOut(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		System.out.println("***************** ADDING ADDRESS ************************");
		HttpSession s = request.getSession();
		Cookie[] cookies;
		
		String address = request.getParameter("address");
		String userId = (String) s.getAttribute("UN");
		System.out.println(userId);
		
		int id = Integer.parseInt(userId);
		
		if(id != 0) {
			UserService.addAddress(id, address);
			System.out.println("Address added!");
		}
		
		UserService.updateTransaction(id);
		System.out.println("Transaction updated!");
		System.out.println("*******************************************");
		cookies = request.getCookies();
		for (Cookie c : cookies) {
			if(c.getName().equals("USER")) {
				request.getRequestDispatcher("user.jsp").forward(request, response);
			} else if(c.getName().equals("GUEST")) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}
}
