package tinder;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/tinder")
public class Servlet1 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String from="rushikeshss1632@gmail.com";
		 String to=req.getParameter("email");
		 Random  random = new Random();
		 int otp=random.nextInt(1000000);
		 
		 HttpSession hs=req.getSession();
		 hs.setAttribute("otp", otp);
		 
		 Properties properties = System.getProperties();
		 properties.put("mail.smtp.host", "smtp.gmail.com");
		 properties.put("mail.smtp.port", "465");
		 
		 properties.put("mail.smtp.ssl.enable", "true");
		 properties.put("mail.smtp.auth", "true");
		 
		 Session session=Session.getInstance(properties,new A());
		 session.setDebug(true);
		 
		 MimeMessage message=new MimeMessage(session);
		 
		 try {
			InternetAddress address=new InternetAddress(from);
			InternetAddress address2=new InternetAddress(to);
			
			message.setFrom(address);
		       message.addRecipient(RecipientType.TO, address2);   
		       message.setSubject("One Time Password" );
		       message.setText(" Hi, your one time password is "+ otp);
		       Transport.send(message);  
		} catch (Exception e) 
		 {
			e.printStackTrace();
		}
		 RequestDispatcher rd=req.getRequestDispatcher("otp.html");
		 rd.forward(req, resp);
	}
}
