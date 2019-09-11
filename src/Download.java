
import java.io.FileInputStream;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Download.java")
public class Download extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String books = request.getParameter("choice");
		if(books==null)
		{
			System.out.println("Choice ni aari");
		}
		if (books.endsWith("pdf")) {
			response.setContentType("application/pdf");
		} else {
			response.setContentType("application/msword");
		}
		FileInputStream fi = new FileInputStream("C:\\Users\\Ayushi\\Desktop\\ssi\\" + books);
		byte[] b = new byte[fi.available()];
		fi.read();
		fi.close();
		ServletOutputStream s = response.getOutputStream();
		s.write(b);
		s.close();

	}

}
