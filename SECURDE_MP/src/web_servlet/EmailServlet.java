package web_servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
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

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet(urlPatterns= {"/sendVerification"})
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SECURDE_EMAIL = "securdeproject@gmail.com";
	private static final String SECURDE_PASS = "Securdeproj";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(request.getServletPath()) {
		   case "/sendVerification": performVerification(request, response); break;
		   default: System.out.println("Inside EmailServlet: URL NOT FOUND.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void performVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("******************SENDING VERIFICATION********************");
		String email = (String) request.getAttribute("email");
		String newVerificationId = (String) request.getAttribute("verificationId");

		String resultMessage = "";
		int port = request.getServerPort(); //get port of the server.
		String name = request.getServerName(); //get name of server.
		String generatedURL = "http://" + name + ":" + port +"/SECURDE_MP/verification?verify=" + newVerificationId;
		String generatedMsg = 	"Hi!"
								+ "\n\n"
								+ "Please click the link below to activate/confirm your account."
								+ "\n\n"
								+ generatedURL
								+ "\n\n"
								+"Thank you!";
		String subject = "Account Confirmation";
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true"); 
		properties.put("mail.smtp.starttls.enable", "true");  
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties,  
			    new javax.mail.Authenticator() {  
					@Override
		      		protected PasswordAuthentication getPasswordAuthentication() {  
		      			return new PasswordAuthentication(SECURDE_EMAIL, SECURDE_PASS);  
		      		}  
		    });
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SECURDE_EMAIL));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(subject);
			message.setText(generatedMsg);
			
            Transport.send(message);
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

}
