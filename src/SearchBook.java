
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			String sql = "select BookName from books where Subject like ?";

			ps = con.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String s = request.getParameter("subject");
		try {
			ps.setString(1,  s + "%" );
			rs = ps.executeQuery();
			while (rs.next()) {
				String bookName1 = rs.getString(1);
				out.println("<table border=1>");
			    out.println("<tr>");
			    out.println("<th>Book Name</th>");
			    out.println("</tr>");
			    out.println("<tr>");
			    out.println("<td>");
			    out.println(bookName1);
			    out.println("</td>");
			    out.println("</tr>");
			    
			    
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		try {
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
