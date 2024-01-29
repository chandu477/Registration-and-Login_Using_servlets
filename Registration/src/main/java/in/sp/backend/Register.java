package in.sp.backend;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registration-form")
public class Register extends HttpServlet{
	

	
	 public void doGet(HttpServletRequest request, 
		      HttpServletResponse response)
		      throws ServletException, IOException 
		   {
		 RequestDispatcher rd =request.getRequestDispatcher("/register.jsp");
 		rd.include(request, response);
		  
		   }
	   

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
              PrintWriter out= response.getWriter();
	        // Retrieve form parameters
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String city = request.getParameter("city");
	        String gender = request.getParameter("gender");
	        
	        //jdbc (java datbase connectivity)
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	
	        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration_data","root","Mumbai@123");
	        	PreparedStatement ps=con.prepareStatement("insert into register value(?,?,?,?,?)");
	        	
	        	ps.setString(1, name);
	        	ps.setString(2, email);
	        	ps.setString(3, password);
	        	ps.setString(4, city);
	        	ps.setString(5, gender);
	        	
	        	int count=ps.executeUpdate();
	        	if(count>0) {
	        		response.setContentType("text/html");
	        		out.println("<h3 style='color:green'>Thankyou! You have registered Sucessfully</h3>");
	        		//redirect to the new page 
	        		RequestDispatcher rd =request.getRequestDispatcher("/login.jsp");
	        		rd.include(request, response);
	        		
	        	}else {
	        		response.setContentType("text/html");
	        		out.println("<h3 style='color:red'>Error ! You have registered issues</h3>");
	        		
	        		//redirect to the new page 
      		    RequestDispatcher rd =request.getRequestDispatcher("/register.jsp");
        		rd.include(request, response);
	        	}
	        }
	        catch(Exception e){
	        	
	        	e.printStackTrace();
	        	
	        	response.setContentType("text/html");
        		out.println("<h3 style='color:red'>Erroe ! You have registered issues</h3>");
        		
        		//redirect to the new page 
        		RequestDispatcher rd =request.getRequestDispatcher("/register.jsp");
        		rd.include(request, response);
	        }

	        
	    }
	}


