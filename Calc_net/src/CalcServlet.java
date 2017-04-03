
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		double Res=0;
		double a = Double.parseDouble((String) request.getParameter("aNum"));
		double b = Double.parseDouble((String) request.getParameter("bNum"));
		String op = (String) request.getParameter("oPer");
		switch(op)
		{
			case "+": Res = a+b; 
					  break;
			case "-": Res = a-b; 
			  		  break;
			case "*": Res = a*b; 
			  		  break;
			case "/": Res = a/b; 
			  		  break;
			default: break;
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.getWriter().println(Res);   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
