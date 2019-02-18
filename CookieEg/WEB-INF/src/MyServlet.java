import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse rep) throws IOException
	{
		PrintWriter output=rep.getWriter();
		
		Cookie c=new Cookie("repeatvisitor", "yes");
		c.setMaxAge(60);
		rep.addCookie(c);
		
		boolean newUser=true;
		Cookie[] cookie=req.getCookies();
		
		if(cookie!=null)
		{
		for(Cookie save:cookie)
		{
			//Cookie save=cookie[i];
			String title;
			if((save.getName().equals("repeatvisitor"))&&(save.getValue().equals("yes")))
			 {
				newUser=false;
				title="Welcome back";
				output.println("<h1>"+title+"<h1>");
				
			 }
			else
			{
				title="Welcome New User";
				output.println("<h1>"+title+"</h1>");
			}
			
				
			
			
		}
		}
		
		
		
	}

}
