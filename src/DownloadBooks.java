import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadBooks")
public class DownloadBooks extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File f= new File("C:\\Users\\Ayushi\\Desktop\\ssi\\");
		String s[]= f.list();
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<body>");
		for(String b: s) {
			out.println("<a href='Download.java?choice="+b+"'> "+b+"</a>");
			out.println("<br>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
