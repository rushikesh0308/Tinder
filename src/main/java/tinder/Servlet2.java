package tinder;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/otpvalidate")
public class Servlet2 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String otp1=req.getParameter("otp");
		Integer otp2=Integer.parseInt(otp1);
		HttpSession hs1=req.getSession();
		Integer otp=(Integer) hs1.getAttribute("otp");
		PrintWriter pw=resp.getWriter();
		
		System.out.println(otp);
		System.out.println(otp2);
		if(otp.equals(otp2))
		{
			pw.println("account created");
		}else {
			pw.println("Invalid otp");
		}
	}
}
